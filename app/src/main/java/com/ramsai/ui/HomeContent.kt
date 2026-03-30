package com.ramsai.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ramsai.ui.theme.*

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 24.dp)
            .padding(top = 96.dp, bottom = 120.dp)
    ) {
        HeroSection()
        Spacer(modifier = Modifier.height(48.dp))
        CategoryChips()
        Spacer(modifier = Modifier.height(64.dp))
        RecentRecipesSection()
    }
}

@Composable
fun HeroSection() {
    Column {
        Text(
            text = "Crafting culinary",
            fontFamily = headlineFontFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 48.sp,
            lineHeight = 56.sp,
            letterSpacing = (-1).sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "magic with AI.",
            fontFamily = headlineFontFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 48.sp,
            lineHeight = 56.sp,
            letterSpacing = (-1).sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Turn your available ingredients into a Michelin-star experience in seconds.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 40.dp)
        )
        AIInputShell()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AIInputShell() {
    var text by remember { mutableStateOf("") }

    Surface(
        color = surface_container_lowest,
        shape = RoundedCornerShape(40.dp),
        shadowElevation = 12.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = "AI",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(16.dp))
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text("What do you want to eat?", color = MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                Icon(
                    imageVector = Icons.Default.Mic,
                    contentDescription = "Microphone",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { }
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Generate Recipe",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Generate")
            }
        }
    }
}

@Composable
fun CategoryChips() {
    val categories = listOf("Quick & Easy", "Healthy", "Vegetarian", "Dinner Ideas", "Desserts")

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { category ->
            val isFirst = category == "Quick & Easy"
            Surface(
                color = if (isFirst) secondary_fixed_dim else surface_container,
                contentColor = if (isFirst) on_secondary_fixed_variant else MaterialTheme.colorScheme.onSurfaceVariant,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.clickable { }
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
fun RecentRecipesSection() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "FRESH PICKS",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "Recent Recipes",
                    fontFamily = headlineFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }
            Text(
                text = "View all >",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { }
            )
        }

        LargeRecipeCard()
        Spacer(modifier = Modifier.height(24.dp))
        SmallRecipeCard(
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBENmsC2q4M2rp-pjMA6Swb_pvMJzAw5s3FkXjwnjqOzUnAFxFDQEXa7FJ0cc0pzrrncCum_OIlyvr784kAPACwQcm5-_7CbTVPOJxOYjTORb_cbeMuav8AdKQZJ24dyvWvr4vpzOWNQhMQT3IZxaX4P1SNMO65cvke-lBD3tEjZYEzrFrOECuxOYcRdGsG3k1sUD9BZ65EwaqKRNocfj7TRJ2QLSvldoJ2wJN08h2NtrBsiL6uLyv4uAORbtT95Sy5ppyAxMJpLwBA",
            title = "Wild Mushroom Risotto",
            subtitle = "Umami Profile",
            rating = "4.9",
            difficulty = "Intermediate",
            time = "35 mins"
        )
        Spacer(modifier = Modifier.height(24.dp))
        SmallRecipeCard(
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCSmf0L45qUoEN4njITNaTc8--kXmJoQp5k7dTDpKdCSR5dN0htZv_lQRi1Q91yMlPJKF8PptCodtaOoK440MfJ5v82EYzJtGUFmCQoLbSRTl8b2X-XIh6K4O7J-9ANvZlN3iikQPoH8yadnHiqDWUTSjWFfWl6WxZRlJ15E1EAiG-FcCFwBszRpZuXL_gxvBK7wUg0UKgZxyCvcJYjuZqTPn4M_nr0FyqTcIRlwi8jd2QRFeXNwuLKAHLTB4PjX1MnUiz-N1QP4OjH",
            title = "Garden Mezze Platter",
            subtitle = "Plant-Based",
            rating = "4.7",
            difficulty = "Easy",
            time = "15 mins"
        )
        Spacer(modifier = Modifier.height(24.dp))
        HorizontalRecipeCard()
    }
}

@Composable
fun LargeRecipeCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(surface_container_low)
    ) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuD7pXGp_TTz1dwOdTSGQg-Hq4SKlZ_b-a_YL-HHGoRL3g9EEUIHCUnFKlogIL3C27rogX1DMp5KCvVoWtpnZDZtfM9eiKJTbPn8EzutcUCPWumGfoEkOQkOR0NSvtNIia4l6tGbzdOzBLfyWvDDZWU9FDWYmCb2CVwvzDiu3sEwZ-KpQYsM7jzrjsAfPqMlrjsG67J0GaNbKyy4SDc-WlsRxLy5WVe5ZXrdFjI5B_JWlrCg0hkwp6xtugqaWyre8JGmGcoJEiG-ZbqA",
            contentDescription = "Summer Harvest Buddha Bowl",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                        startY = 200f
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(32.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "EDITOR'S CHOICE",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = "Time",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "25 mins",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
            Text(
                text = "Summer Harvest Buddha Bowl",
                fontFamily = headlineFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 36.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "A vibrant blend of seasonal micro-greens, roasted chickpeas, and a zesty tahini dressing.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
fun SmallRecipeCard(
    imageUrl: String,
    title: String,
    subtitle: String,
    rating: String,
    difficulty: String,
    time: String
) {
    Surface(
        color = surface_container_lowest,
        shape = RoundedCornerShape(40.dp),
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .padding(bottom = 24.dp)
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Surface(
                    color = Color.White.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = rating,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
            Text(
                text = subtitle.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = title,
                fontFamily = headlineFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Restaurant,
                        contentDescription = "Difficulty",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = difficulty,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(
                    text = time,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun HorizontalRecipeCard() {
    Surface(
        color = surface_container_lowest,
        shape = RoundedCornerShape(40.dp),
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = "https://lh3.googleusercontent.com/aida-public/AB6AXuATbo0u2zJ9Bx28KKeTpTJ3WXtarv4BwXrPGlfc31xx4PZSNoAgyH9UEeAD6-CR6gRzNWgFT8fSfw1WjYLYgQgmVGWyVC72EoBAkc-GftKEvirrX47AHgEaVU6SQmDpYG069FIZvJ5zMH2t31ulUwvfzUDitSKKuZyCY-KWc7nkQiq6ev4zRsbxHioDHj_JSGbQX-8T0OmZAcgHwjCL1_DKRVP0TKUNcUpkixsjNOVih4MCYpbSfWYioAEXiebBEhOqFpQqLBOgt9or",
                contentDescription = "Basil Pesto Penne",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Column(
                modifier = Modifier.padding(32.dp)
            ) {
                Row(
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    Surface(
                        color = Color(0xFFdcfce7),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "HEALTHY",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF166534),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Surface(
                        color = Color(0xFFffedd5),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "QUICK",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF9a3412),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }
                Text(
                    text = "Basil Pesto Penne",
                    fontFamily = headlineFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Authentic Italian style pesto made from scratch with toasted pine nuts and aged parmesan.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "CALORIES",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            text = "420 kcal",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "TIME",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            text = "12 mins",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(surface_container)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Bookmark",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
