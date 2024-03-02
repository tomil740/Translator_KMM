package com.plcoding.translator_kmm.translate.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual class HttpClientFactory {

    actual fun create(): HttpClient {
        return HttpClient(Darwin){
            //kind of the moshi convertor we add to the retrofit builder , in ktor we will implement an plugins for extra
            //functionality from the httpCliient we will sent to build the request
            install(ContentNegotiation){
                json()
            }
        }
    }

}