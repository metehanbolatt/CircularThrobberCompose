package com.metehanbolat.circularthrobbercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.circularthrobbercompose.ui.theme.CircularThrobberComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularThrobberComposeTheme {

            }
        }
    }
}
