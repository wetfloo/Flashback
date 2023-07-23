package io.wetfloo.flashback.util

import android.content.Context
import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext
import kotlinx.parcelize.Parcelize

@Stable
sealed interface UiString : Parcelable {
    fun getString(context: Context): String
}

@Composable
fun UiString.string() = getString(LocalContext.current)

@Parcelize
data class Res(
    @StringRes val stringRes: Int,
    val args: List<String> = emptyList(),
) : UiString {
    constructor(
        @StringRes stringRes: Int,
        vararg args: Any,
    ) : this(
        stringRes = stringRes,
        args = args.map { it.toString() },
    )

    override fun getString(context: Context) = context.getString(
        stringRes,
        args,
    )
}

@Parcelize
data class Raw(val string: String) : UiString {
    override fun getString(context: Context) = string
}
