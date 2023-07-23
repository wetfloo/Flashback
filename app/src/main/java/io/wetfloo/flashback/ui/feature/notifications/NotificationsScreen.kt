package io.wetfloo.flashback.ui.feature.notifications

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.wetfloo.flashback.ui.nav.PagedNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
@PagedNavGraph(start = true)
fun NotificationsScreen(
    navigator: DestinationsNavigator,
    viewModel: NotificationsViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val list by viewModel
        .itemsState
        .collectAsStateWithLifecycle()

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
    ) { scaffoldPaddingValues ->
        LazyColumn(
            contentPadding = scaffoldPaddingValues,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(items = list) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"),
                            )
                        }
                )
            }
        }
    }
}
