package io.wetfloo.flashback.ui.feature.settings

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.wetfloo.flashback.ui.nav.PagedNavGraph

@Composable
@Destination
@PagedNavGraph
fun SettingsScreen(
    navigator: DestinationsNavigator,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state by viewModel
        .textState
        .collectAsStateWithLifecycle()

    Text(
        text = state,
        modifier = Modifier
            .clickable {
                navigator.popBackStack()
            },
    )
}
