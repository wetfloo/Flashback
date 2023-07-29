package io.wetfloo.flashback.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.wetfloo.flashback.ui.NavGraphs
import io.wetfloo.flashback.ui.destinations.NotificationsScreenDestination
import io.wetfloo.flashback.ui.destinations.SettingsScreenDestination
import io.wetfloo.flashback.ui.feature.notifications.NotificationsScreen
import io.wetfloo.flashback.ui.feature.settings.SettingsScreen

@RootNavGraph(start = true)
@Destination
@Composable
fun PagedScreen(
    navigator: DestinationsNavigator,
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            PagedBar(navController = navController)
        },
    ) { scaffoldPaddingValues ->
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.paged,
            modifier = Modifier
                .padding(scaffoldPaddingValues),
        ) {
            composable(NotificationsScreenDestination) {
                NotificationsScreen(navigator = navigator)
            }

            composable(SettingsScreenDestination) {
                SettingsScreen(navigator = navigator)
            }
        }
    }
}
