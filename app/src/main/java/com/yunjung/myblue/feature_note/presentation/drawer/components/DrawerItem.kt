package com.yunjung.myblue.feature_note.presentation.drawer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.ui.theme.MyBlueTheme
import com.yunjung.myblue.ui.theme.pointColor
import com.yunjung.myblue.R
import com.yunjung.myblue.ui.theme.Donoun

@Composable
fun DrawerItem(
    name : String
) {
    Box(
        modifier = Modifier
            .background(color = pointColor)
            .border(1.dp, SolidColor(Color.White), RectangleShape)
            .height(50.dp)
            .width(120.dp)
    ){
        // 이름표
        Row(
            modifier = Modifier
                .padding(2.dp) // Outer Padding
                .align(Alignment.TopEnd)
                .clip(RoundedCornerShape(2.dp))
                .background(Color.White)
                .padding(1.dp) // Inner Padding
        ) {
            Text(
                text = name,
                style = TextStyle(fontSize = 5.sp, fontFamily = Donoun),
                modifier = Modifier
                    .background(Color.White)
                    .border(0.5.dp, SolidColor(Color.Red) ,
                        RoundedCornerShape(2.dp))
                    .width(30.dp)
                    .padding(2.dp), // Inner Padding
            textAlign = TextAlign.Center
            )
        }
        // 손잡이
        Image(
            painter = painterResource(R.drawable.ic_circle),
            contentDescription = "손잡이",
            modifier = Modifier
                .align(Alignment.Center)
                .size(8.dp)
        )
    }
}

// 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBlueTheme {
        DrawerItem("와인바")
    }
}