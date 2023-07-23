package io.wetfloo.flashback.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    /*
    Not sure how expensive calculating paddings is really, putting this here just in case

    TODO: Measure how many object memory allocations this saves on recompositions.
        Also try with different key combinations and without this remember block at all
    */
    return remember(this, other, layoutDirection) {
        PaddingValues(
            start = calculateStartPadding(layoutDirection) +
                    other.calculateStartPadding(layoutDirection),
            top = calculateTopPadding() +
                    other.calculateTopPadding(),
            end = calculateEndPadding(layoutDirection) +
                    other.calculateEndPadding(layoutDirection),
            bottom = calculateBottomPadding() +
                    other.calculateBottomPadding(),
        )
    }
}

@Composable
fun PaddingValues.add(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
) = this + PaddingValues(
    start = start,
    top = top,
    end = end,
    bottom = bottom,
)

@Composable
fun PaddingValues.add(
    horizontal: Dp = 0.dp,
    vertical: Dp = 0.dp,
) = this + PaddingValues(
    horizontal = horizontal,
    vertical = vertical,
)


@Composable
fun PaddingValues.add(
    all: Dp = 0.dp,
) = this + PaddingValues(all)
