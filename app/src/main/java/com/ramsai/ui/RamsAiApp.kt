package com.ramsai.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RamsAiApp() {
    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomNavBar() },
        floatingActionButton = { FloatingActionButton() }
    ) { innerPadding ->
        HomeContent(modifier = Modifier.padding(innerPadding))
    }
}
