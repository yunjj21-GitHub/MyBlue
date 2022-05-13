package com.yunjung.myblue.feature_note.presentation.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.feature_note.presentation.drawer.components.DrawerItem
import com.yunjung.myblue.ui.theme.*

@Composable
fun DrawerScreen(drawerName : List<String>) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Floating Button Click Event
                },
                backgroundColor = pointColor
            ) {
               Icon(imageVector = Icons.Default.Add, contentDescription = "Add Drawer", tint = Color.White)
            }
        },
        scaffoldState = rememberScaffoldState()
    ){
        /* 화면 디자인 */
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            // 앱 이름
            Text(
                text = "My Blue",
                color = pointColor,
                style = TextStyle(
                    fontSize = 40.sp,
                    fontFamily = YUniverse,
                    fontWeight = Bold
                ),
                modifier = Modifier
                    .padding(64.dp) // Outer Padding
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // 서랍
            // 서랍 윗단
            Spacer(
                modifier = Modifier
                    .padding(32.dp , 0.dp , 32.dp , 0.dp)
                    .clip(RoundedCornerShape(15.dp , 15.dp , 0.dp , 0.dp))
                    .background(mainColor)
                    .fillMaxWidth()
                    .height(25.dp)
            )

            // 서랍 칸
            for(name in drawerName){
                DrawerItem(name = name)
            }

            // 서랍 아랫단
            Spacer(
                modifier = Modifier
                    .padding(32.dp , 0.dp , 32.dp , 64.dp)
                    .clip(RoundedCornerShape(0.dp , 0.dp , 15.dp , 15.dp))
                    .background(mainColor)
                    .fillMaxWidth()
                    .height(25.dp)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreView(){
    var drawerNames = mutableListOf<String>("와인바", "카페", "비건식당", "영화", " ", " ")
    MyBlueTheme {
        DrawerScreen(drawerNames)
    }
}