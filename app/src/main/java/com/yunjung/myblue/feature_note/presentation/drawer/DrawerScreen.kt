package com.yunjung.myblue.feature_note.presentation.drawer

import android.app.AlertDialog
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunjung.myblue.R
import com.yunjung.myblue.feature_note.presentation.drawer.components.AddDrawerDialog
import com.yunjung.myblue.feature_note.presentation.drawer.components.DrawerItem
import com.yunjung.myblue.ui.theme.*

@Composable
fun DrawerScreen(
    navController: NavController
) {
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog.value = true
                },
                backgroundColor = pointColor
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Drawer", tint = Color.White)

                if (openDialog.value) {
                    Dialog(
                        onDismissRequest = {
                            openDialog.value = false
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .width(320.dp)
                                .height(365.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                        ) {
                            // 닫기 버튼
                            Image(
                                painter = painterResource(R.drawable.ic_close) ,
                                contentDescription = "CloseIcon" ,
                                modifier = Modifier
                                    .padding(0.dp , 15.dp , 15.dp , 0.dp)
                                    .fillMaxWidth()
                                    .height(35.dp) ,
                                alignment = Alignment.TopEnd
                            )

                            // 중간 이미지
                            Image(
                                painter = painterResource(id = R.drawable.ic_empty_drawer) ,
                                contentDescription = "EmptyDrawerImage" ,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(75.dp) ,
                                alignment = Alignment.Center ,
                            )

                            // Tile
                            Text(
                                text = "서랍 생성하기" ,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 23.sp ,
                                    fontWeight = FontWeight.Bold ,
                                    textAlign = TextAlign.Center
                                ) ,
                                modifier = Modifier
                                    .padding(0.dp , 10.dp , 0.dp , 0.dp)
                                    .fillMaxWidth()
                            )

                            // Content
                            Text(
                                text = "새롭게 생성할\n서랍의 이름을 지어주세요." ,
                                style = TextStyle(
                                    color = Color.Gray ,
                                    fontWeight = FontWeight.Bold ,
                                    textAlign = TextAlign.Center
                                ) ,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )

                            // 서랍 이름을 받아오는 TextField
                            var newDrawerName by remember { mutableStateOf(TextFieldValue("")) }
                            OutlinedTextField(
                                value = newDrawerName ,
                                onValueChange = { it ->
                                    newDrawerName = it
                                } ,
                                label = null ,
                                singleLine = true ,
                                modifier = Modifier
                                    .padding(30.dp , 0.dp , 30.dp , 0.dp)
                                    .fillMaxWidth()
                            )

                            // 완료 버튼
                            Button(
                                onClick = {
                                    // 완료 버튼 클릭 이벤트
                                } ,
                                modifier = Modifier
                                    .padding(30.dp , 10.dp , 30.dp , 10.dp)
                                    .fillMaxWidth()
                                    .height(55.dp)
                            ) {
                                Text(text = "완료")
                            }
                        }
                    }
                }
            }
        },
        scaffoldState = rememberScaffoldState()
    ){
        // 뷰모델 작업
        var drawerNames = mutableListOf<String>("소설", "와인바", "비건식당", "영화", "", "")

        /* 화면 디자인 */
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
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
                    .padding(50.dp) // Outer Padding
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
            for(name in drawerNames){
                DrawerItem(navController = navController, name = name)
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
fun DrawerPreView(){
    MyBlueTheme {
        DrawerScreen(rememberNavController())
    }
}