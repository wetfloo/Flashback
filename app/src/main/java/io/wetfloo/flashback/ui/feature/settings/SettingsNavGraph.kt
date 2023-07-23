package io.wetfloo.flashback.ui.feature.settings

import com.ramcosta.composedestinations.annotation.NavGraph
import io.wetfloo.flashback.ui.nav.PagedNavGraph

@PagedNavGraph
@NavGraph
annotation class SettingsNavGraph(val start: Boolean = false)
