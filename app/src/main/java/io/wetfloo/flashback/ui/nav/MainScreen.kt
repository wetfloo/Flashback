package io.wetfloo.flashback.ui.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.wetfloo.flashback.ui.NavGraphs

@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
) {
    DestinationsNavHost(
        navGraph = NavGraphs.main,
        modifier = Modifier.fillMaxSize(),
    )
}
