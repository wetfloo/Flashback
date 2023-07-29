package io.wetfloo.flashback.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import io.wetfloo.flashback.ui.NavGraphs
import io.wetfloo.flashback.ui.appCurrentDestinationAsState

@Composable
fun PagedBar(
    navController: NavController,
) {
    val currentDestination by navController.appCurrentDestinationAsState()

    NavigationBar {
        PagedBarDestination.values().forEach { destination ->
            val isCurrentDestinationOnBackStack =
                navController.isRouteOnBackStack(destination.direction)
            val destinationLabel = stringResource(destination.label)

            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    if (isCurrentDestinationOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(destination.direction, false)
                        return@NavigationBarItem
                    }

                    navController.navigate(destination.direction) {
                        // Pop up to the root of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destinationLabel,
                    )
                },
                label = {
                    Text(text = destinationLabel)
                },
            )
        }
    }
}
