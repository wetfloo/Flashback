package io.wetfloo.flashback.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.wetfloo.flashback.ui.destinations.Destination

@Composable
fun PagedBar(
    onItemClick: (PagedBarDestination) -> Unit,
    currentDestination: Destination?,
) {
    NavigationBar {
        PagedBarDestination.values().forEach { destination ->
            val destinationLabel = stringResource(destination.label)

            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = { onItemClick(destination) },
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
