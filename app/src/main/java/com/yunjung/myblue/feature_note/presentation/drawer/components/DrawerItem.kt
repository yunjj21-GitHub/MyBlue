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
import com.yunjung.myblue.ui.theme.mainColor

@Composable
fun DrawerItem(
    name : String
) {
    Box(
        modifier = Modifier
            .padding(32.dp, 0.dp, 32.dp, 0.dp) // Outer Padding
            .background(color = mainColor)
            .border(1.dp, SolidColor(Color.White), RectangleShape)
            .height(80.dp)
            .fillMaxWidth()
    ){
        // 이름표
        Row(
            modifier = Modifier
                .padding(5.dp) // Outer Padding
                .align(Alignment.TopEnd)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White)
                .padding(2.dp) // Inner Padding
        ) {
            Text(
                text = name,
                style = TextStyle(fontSize = 12.sp, fontFamily = Donoun),
                modifier = Modifier
                    .background(Color.White)
                    .border(1.dp, SolidColor(Color.Red) ,
                        RoundedCornerShape(4.dp))
                    .width(64.dp)
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
                .size(12.dp)
        )
    }
}

// 미리보기
@Preview(showBackground = true)
@Composable
fun DrawerItemPreview() {
    MyBlueTheme {
        DrawerItem("와인바")
    }
}