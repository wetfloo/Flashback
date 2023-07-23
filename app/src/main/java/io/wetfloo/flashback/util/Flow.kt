package io.wetfloo.flashback.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <F, T> Flow<Iterable<F>>.mapIter(crossinline mapper: suspend (F) -> T) =
    map { iter ->
        iter.map { item -> mapper(item) }
    }

fun <T> Flow<T>.toReadyState(): Flow<Ready<T>> = map { Ready(it) }
