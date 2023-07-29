package io.wetfloo.flashback.ui.feature.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
    // Trying to navigate with a NavController passed down from the parent
    // doesn't work. Don't know why, but it does work when passing DestinationsNavigator.
    navigator: DestinationsNavigator,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state by viewModel
        .textState
        .collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Text(
            text = state,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigator.popBackStack()
                },
        )
    }
}
