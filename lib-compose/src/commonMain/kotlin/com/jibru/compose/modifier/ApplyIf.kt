package com.jibru.compose.modifier

import androidx.compose.ui.Modifier

// extra extension functions for Modifier necessary as generic type from ApplyIf.kt takes Companion object instead of interface :/
inline fun Modifier.applyIf(value: Boolean, modifier: Modifier.() -> Modifier) = run { if (value) modifier() else this }

inline fun <T> Modifier.applyIfNotNull(value: T?, block: Modifier.(T) -> Modifier) = run { if (value != null) block(value) else this }
