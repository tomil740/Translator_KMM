package com.plcoding.translator_kmm.core.domain.core

import com.plcoding.translator_kmm.core.domain.util.CommonMutableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.toCommonMutableStateFlow() = CommonMutableStateFlow(this)


