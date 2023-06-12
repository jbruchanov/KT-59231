package com.jibru.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jibru.compose.ext.targetThickness
import com.jibru.compose.modifier.applyIf

private object DividersDefaults {
    val DefaultColor @Composable get() = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
}

@Composable
fun DividerVertical(
    modifier: Modifier = Modifier,
    color: Color = DividersDefaults.DefaultColor,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
    endIndent: Dp = 0.dp,
    shape: Shape = RectangleShape
) = with(DividersDefaults) {
    Box(
        modifier
            .applyIf(startIndent.value != 0f || endIndent.value != 0f) {
                padding(top = startIndent, bottom = endIndent)
            }
            .fillMaxHeight()
            .width(thickness.targetThickness())
            .clip(shape)
            .background(color = color)
    )
}

@Composable
fun DividerHorizontal(
    modifier: Modifier = Modifier,
    color: Color = DividersDefaults.DefaultColor,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
    endIndent: Dp = 0.dp,
    shape: Shape = RectangleShape
) = with(DividersDefaults) {
    Box(
        modifier
            .applyIf(startIndent.value != 0f || endIndent.value != 0f) {
                padding(start = startIndent, end = endIndent)
            }
            .fillMaxWidth()
            .height(thickness.targetThickness())
            .clip(shape)
            .background(color = color)
    )
}
