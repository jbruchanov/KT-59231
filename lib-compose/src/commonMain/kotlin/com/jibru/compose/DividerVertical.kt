package com.jibru.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
