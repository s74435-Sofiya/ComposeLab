
package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    FrameBoxScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FrameBoxScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Blue box - bottom layer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFF1565C0))
                .zIndex(0f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "1 (bottom)",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Orange box - middle layer
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 70.dp)
                .size(160.dp)
                .background(Color(0xFFEF6C00))
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2 (middle)",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Red box - top layer
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(80.dp)
                .background(Color(0xFFC62828))
                .zIndex(2f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "3 (top)",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
