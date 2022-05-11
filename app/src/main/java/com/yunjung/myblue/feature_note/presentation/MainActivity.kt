package com.yunjung.myblue.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yunjung.myblue.ui.theme.MyBlueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBlueTheme {
                Surface(color = MaterialTheme.colors.background) {
                    // 화면간의 이동만 정의
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

// 전체 화면 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBlueTheme {
        Greeting("Android")
    }
}