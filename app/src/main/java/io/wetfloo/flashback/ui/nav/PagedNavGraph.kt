package io.wetfloo.flashback.ui.nav

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class PagedNavGraph(val start: Boolean = false)
