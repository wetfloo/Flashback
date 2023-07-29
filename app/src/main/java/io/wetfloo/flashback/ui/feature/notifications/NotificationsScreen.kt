@file:OptIn(ExperimentalMaterial3Api::class)

package io.wetfloo.flashback.ui.feature.notifications

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.wetfloo.flashback.R
import io.wetfloo.flashback.domain.feature.notification.NotificationDomain
import io.wetfloo.flashback.ui.feature.notifications.component.NotificationItem
import io.wetfloo.flashback.ui.nav.PagedNavGraph
import io.wetfloo.flashback.util.add
import io.wetfloo.flashback.util.onReady

@Composable
private fun NotificationsScreenContent(
    state: List<NotificationDomain>,
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.notifications_title),
                    )
                },
            )
        },
    ) { scaffoldPaddingValues ->
        Column {
            LazyColumn(
                contentPadding = scaffoldPaddingValues
                    .add(top = 16.dp),
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(
                    items = state,
                    key = { item -> item.uuid },
                ) { notification ->
                    NotificationItem(
                        notification = notification,
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
            }
        }
    }
}

@Composable
@Destination
@PagedNavGraph(start = true)
fun NotificationsScreen(
    // Trying to navigate with a NavController passed down from the parent
    // doesn't work. Don't know why, but it does work when passing DestinationsNavigator.
    navigator: DestinationsNavigator,
    viewModel: NotificationsViewModel = hiltViewModel(),
) {
    val state by viewModel
        .notifications
        .collectAsStateWithLifecycle()

    state.onReady { list ->
        NotificationsScreenContent(state = list)
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//private fun NotificationsScreenPreview() {
//    AppTheme {
//        val items = remember {
//            (0..100)
//                .map { "Item $it" }
//                .map { str ->
//                    NotificationDomain(
//                        content = str,
//                        dateTime = LocalDateTime.now(),
//                        id = UUID.randomUUID().hashCode(),
//                    )
//                }
//        }
//
//        NotificationsScreenContent(state = items)
//    }
//}
