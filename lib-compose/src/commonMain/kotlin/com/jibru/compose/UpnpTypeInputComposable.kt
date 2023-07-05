package com.jibru.compose

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal interface UpnpTypeInputComposable {

    val defaultSpacing get() = 4.dp
    val sliderHorizontalPadding get() = defaultSpacing * 4

    @Composable
    fun GenericText(
        label: String,
        defaultValue: String,
        onValueChanged: (String) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true
    ) {

        var text by remember { mutableStateOf(defaultValue) }
        var valid by remember { mutableStateOf(true) }

        OutlinedTextField(
            value = text,
            isError = !valid,
            label = { Text(label) },
            enabled = enabled,
            onValueChange = {
                text = it
                onValueChanged(it)
            },
            modifier = modifier
        )
    }

    companion object : UpnpTypeInputComposable
}

@Composable
fun UpnpInput(
    onValueChanged: (Any) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    initialValue: String? = null
) = with(UpnpTypeInputComposable) {
    when {
        else -> GenericText(
            label = "variable.name",
            defaultValue = "",
            onValueChanged = onValueChanged,
            modifier = modifier,
            enabled = enabled
        )
    }
}
