@file:OptIn(ExperimentalObjCRefinement::class)

package com.jibru.compose.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isFinite
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

inline fun Dp.finiteOrElse(value: () -> Dp) = if (isFinite) this else value()
fun Dp.toPx(density: Density): Float = with(density) { this@toPx.toPx() }
fun Dp.toPx(density: Float): Float = this.value * density

@Composable
@HiddenFromObjC
fun Dp.targetThickness() = if (this == Dp.Hairline) (1f / LocalDensity.current.density).dp else this

@Composable
@HiddenFromObjC
fun Dp.targetThicknessPx() = if (this == Dp.Hairline) 1f else this.toPx(LocalDensity.current)
