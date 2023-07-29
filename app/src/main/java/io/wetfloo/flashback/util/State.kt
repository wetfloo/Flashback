package io.wetfloo.flashback.util

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

typealias MutableStatefulFlow<T> = MutableStateFlow<State<T>>
typealias StatefulFlow<T> = StateFlow<State<T>>

@Stable
sealed interface State<out T>

object Idle : State<Nothing>
object Loading : State<Nothing>
data class Ready<out T>(val data: T) : State<T>

inline fun <T> State<T>.onReady(action: (T) -> Unit) {
    if (this is Ready) {
        action(data)
    }
}
