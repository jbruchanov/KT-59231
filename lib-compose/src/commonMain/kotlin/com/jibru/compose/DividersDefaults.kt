@file:OptIn(ExperimentalObjCRefinement::class)

package com.jibru.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@HiddenFromObjC
object DividersDefaults {
    val DefaultColor @Composable get() = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
}
