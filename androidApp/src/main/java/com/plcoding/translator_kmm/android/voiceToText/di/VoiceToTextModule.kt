package com.plcoding.translator_kmm.android.voiceToText.di

import android.app.Application
import com.plcoding.translator_kmm.android.voiceToText.data.AndroidVoiceToTextParser
import com.plcoding.translator_kmm.voiceToText.domain.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object VoiceToTextModule {

    @Provides
    @ViewModelScoped
    fun provideVoiceToTextParser(app: Application): VoiceToTextParser {
        return AndroidVoiceToTextParser(app)
    }
}