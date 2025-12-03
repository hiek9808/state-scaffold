package com.sumaqada.state_scaffold

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun <T> StateLayout(
    state: UiState<T>,
    modifier: Modifier = Modifier,
    loadingContent: @Composable () -> Unit = { DefaultLoadingContent() },
    errorContent: @Composable (String) -> Unit = { msg -> DefaultErrorContent(msg) },
    emptyContent: @Composable () -> Unit = { DefaultEmptyContent() },
    content: @Composable (T) -> Unit
) {

    Crossfade(
        targetState = state,
        animationSpec = tween(durationMillis = 500),
        label = "State Animation"
    ) { currentState ->

        Box(modifier = Modifier.fillMaxSize()) {
            when (currentState) {
                is UiState.Loading -> loadingContent()
                is UiState.Empty -> emptyContent()
                is UiState.Error -> errorContent(currentState.message)
                is UiState.Success -> content(currentState.data)
            }
        }
    }

}

@Composable
private fun DefaultLoadingContent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }

}

@Composable
private fun DefaultErrorContent(message: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {

        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Error",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(bottom = 48.dp)
        )
        Spacer(modifier = Modifier.size(48.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error
        )

    }

}

@Composable
fun DefaultEmptyContent() {
    Text(
        text = "No data",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}