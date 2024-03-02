package com.plcoding.translator_kmm.translate.data.translate

import com.plcoding.translator_kmm.NetworkConstants
import com.plcoding.translator_kmm.core.domain.language.Language
import com.plcoding.translator_kmm.translate.domain.translate.TranslateClient
import com.plcoding.translator_kmm.translate.domain.translate.TranslateError
import com.plcoding.translator_kmm.translate.domain.translate.TranslateException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

class KtorTranslateClient (val httpClient: HttpClient):TranslateClient {

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            //the request itself with all of the settings we declare in the ui (domain)
            httpClient.post{
               // set the url base address
                url(NetworkConstants.BASE_URL + "/translate")
                //set the type of result we want to get
                contentType(ContentType.Application.Json)
                //and here we send the data of the request , will be send with the help of the dto object we just created
                //that with the help of his annotations the request will know to use that data in the request
                setBody(
                    TranslateDto(
                        sourceLanguageCode = fromLanguage.langCode, textToTranslate = fromText, targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        } catch(e: IOException) {
            //at this point if there is any exception we will assume problem with the server , and sent the match error from the enum
            //error class we declared
            throw TranslateException(TranslateError.SERVICE_UNAVAILABLE)
        }

        when(result.status.value) {
            //then if we sucses we will check for other error possabilety of result code
            in 200..299 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        //and finally we use try and catch just in case the serialization of the dto object go any error
        //and just take the outcome with the object dto we set to the result we will need
        return try {
            result.body<TranslatedDto>().translatedText
        } catch(e: Exception) {
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}