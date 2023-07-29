package io.wetfloo.flashback.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate
import io.wetfloo.flashback.ui.NavGraphs
import io.wetfloo.flashback.ui.appCurrentDestinationAsState

@RootNavGraph(start = true)
@Destination
@Composable
fun PagedScreen(
    navigator: DestinationsNavigator,
) {
    val navController = rememberNavController()
    val currentDestination by navController.appCurrentDestinationAsState()

    Scaffold(
        bottomBar = {
            PagedBar(
                onItemClick = { destination ->
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                currentDestination = currentDestination,
            )
        },
    ) { scaffoldPaddingValues ->
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.main,
            modifier = Modifier.padding(scaffoldPaddingValues),
        )
    }
}
