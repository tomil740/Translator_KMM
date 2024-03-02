package com.plcoding.translator_kmm.core.domain.core

import com.plcoding.translator_kmm.core.domain.util.CommonFlow
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.toCommonFlow() = CommonFlow(this)