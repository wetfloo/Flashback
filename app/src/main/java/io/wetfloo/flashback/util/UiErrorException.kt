package io.wetfloo.flashback.util

import io.wetfloo.flashback.R

open class UiErrorException(
    val error: UiString,
) : Exception()

fun Exception.toUiErrorException(message: UiString? = null): UiErrorException {
    val error = when {
        message != null -> message
        else -> Res(R.string.error_generic)
    }

    return UiErrorException(error)
}
