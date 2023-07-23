package io.wetfloo.flashback.ui.feature.notifications

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.wetfloo.flashback.domain.repo.NotificationsRepository
import io.wetfloo.flashback.util.Idle
import io.wetfloo.flashback.util.toReadyState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val notificationsRepository: NotificationsRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val notifications = notificationsRepository
        .observeNotifications()
        .toReadyState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Idle,
        )
}
