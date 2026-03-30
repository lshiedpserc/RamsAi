package com.ramsai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramsai.ui.theme.headlineFontFamily
import com.ramsai.ui.theme.md_theme_light_primary
import com.ramsai.ui.theme.md_theme_light_primaryContainer
import com.ramsai.ui.theme.md_theme_light_onPrimaryContainer
import com.ramsai.ui.theme.md_theme_light_onPrimary
import com.ramsai.ui.theme.surface_container_lowest

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.7f))
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.RestaurantMenu,
                contentDescription = "Logo",
                tint = Color(0xFF166534)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "RamsAi",
                fontFamily = headlineFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                color = Color(0xFF14532d)
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable { }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun BottomNavBar() {
    Surface(
        color = Color.White.copy(alpha = 0.8f),
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Home",
                isSelected = true
            )
            BottomNavItem(
                icon = Icons.Default.Menu,
                label = "Recipes",
                isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Settings,
                label = "Settings",
                isSelected = false
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) Color(0xFFdcfce7) else Color.Transparent)
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clickable { }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) Color(0xFF14532d) else Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = if (isSelected) Color(0xFF14532d) else Color.Gray,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun FloatingActionButton() {
    androidx.compose.material3.FloatingActionButton(
        onClick = { },
        containerColor = md_theme_light_primary,
        contentColor = md_theme_light_onPrimary,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.padding(bottom = 80.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Scan Ingredients",
            modifier = Modifier.size(32.dp)
        )
    }
}
