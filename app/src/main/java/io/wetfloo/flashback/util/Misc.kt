package io.wetfloo.flashback.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

/**
 * Returns a new [CoroutineScope] with [SupervisorJob],
 * added together with receiver's [CoroutineContext]
 */
fun CoroutineContext.supervisor(parent: Job? = null) = CoroutineScope(this + SupervisorJob(parent))


/**
 * Returns a new [CoroutineScope] with [SupervisorJob],
 * added together with the default dispatcher from [DispatchersProvider]
 */
fun DispatchersProvider.supervisor(parent: Job? = null) =
    CoroutineScope(default + SupervisorJob(parent))
