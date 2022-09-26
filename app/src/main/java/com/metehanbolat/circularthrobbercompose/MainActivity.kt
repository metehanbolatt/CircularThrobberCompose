package com.metehanbolat.circularthrobbercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.circularthrobbercompose.ui.theme.CircularThrobberComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularThrobberComposeTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        Spinner(modifier = Modifier.size(200.dp))
                    }
                )
            }
        }
    }
}

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    strokeWidth: Float = 20f,
    trackColor: Color = Color.Gray,
    color: Color = MaterialTheme.colors.primary
) {

    val transition = rememberInfiniteTransition()

    val startAngle by transition.animateValue(
        initialValue = 0f,
        targetValue = 360f,
        typeConverter = Float.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(1000, 0, LinearEasing),
            RepeatMode.Restart
        )
    )

    val sweepAngle by transition.animateValue(
        initialValue = 360f,
        targetValue = 0f,
        typeConverter = Float.VectorConverter,
        animationSpec = infiniteRepeatable(
            tween(1500, 0, LinearEasing),
            RepeatMode.Reverse
        )
    )

    Canvas(modifier = modifier) {
        drawCircle(
            trackColor,
            0.4f * size.minDimension,
            style = Stroke(width = strokeWidth)
        )
        drawArc(
            color,
            startAngle,
            sweepAngle,
            false,
            Offset(
                x = 0.1f * size.minDimension,
                y = 0.1f * size.minDimension
            ),
            Size(
                width = 0.8f * size.minDimension,
                height = 0.8f * size.minDimension
            ),
            alpha = 1f,
            Stroke(
                strokeWidth,
                cap = StrokeCap.Round
            )
        )
    }
}

@Preview
@Composable
fun SpinnerPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Spinner(modifier = Modifier.size(200.dp))
        }
    )
}
