package io.wetfloo.flashback.ui.feature.notifications

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _itemsState: MutableStateFlow<List<String>> = MutableStateFlow(mockItemsList)
    val itemsState = _itemsState.asStateFlow()

    companion object {
        private val mockItemsList
            get() = (0..100).map { index ->
                "Item $index"
            }
    }
}
