package com.plcoding.translator_kmm.voiceToText.domain

import com.plcoding.translator_kmm.core.domain.util.CommonStateFlow

interface VoiceToTextParser {

    val state: CommonStateFlow<VoiceToTextParserState>

    fun startListening(languageCode: String)

    fun stopListening()

    fun cancel()

    fun reset()
}

