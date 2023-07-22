package io.wetfloo.flashback

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import io.wetfloo.flashback.ui.NavGraphs
import io.wetfloo.flashback.ui.theme.AppTheme
import io.wetfloo.flashback.ui.theme.TransparentSystemBars

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            TransparentSystemBars()
            AppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
