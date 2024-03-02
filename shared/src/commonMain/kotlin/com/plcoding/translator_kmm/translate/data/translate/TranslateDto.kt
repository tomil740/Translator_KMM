package com.plcoding.translator_kmm.translate.data.translate

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TranslateDto(
    //those parameters is the demand of the api in order to set an request objet to it
    //and the serialName annotation intended to set the parallel attributes name in the jason object to match our named objets
    @SerialName("q") val textToTranslate: String,
    @SerialName("source") val sourceLanguageCode: String,
    @SerialName("target") val targetLanguageCode: String
)
