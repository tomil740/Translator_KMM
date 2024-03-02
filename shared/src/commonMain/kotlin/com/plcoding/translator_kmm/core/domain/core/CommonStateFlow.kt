package com.plcoding.translator_kmm.core.domain.core

import com.plcoding.translator_kmm.core.domain.util.CommonStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T> StateFlow<T>.toCommonStateFlow() = CommonStateFlow(this)