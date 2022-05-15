package com.yunjung.myblue.feature_note.presentation.add_edit_note

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.R
import com.yunjung.myblue.ui.theme.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddEditNoteScreen(
    navController: NavController,
    name : String
) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "글 작성하기",
                        style = TextStyle(fontSize = 20.sp, fontFamily = YUniverse)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp() // 뒤로가기
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "backIcon")
                    }
                },
                backgroundColor = mainColor,
                contentColor = Color.White
            )
        }
    ) {
        /* 화면 구성 */
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            // 이미지
            Image(
                painter = painterResource(R.drawable.ic_image) ,
                contentDescription = "Image Add",
                modifier = Modifier
                    .padding(30.dp , 30.dp , 30.dp , 0.dp)
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(gray)
            )

            // 날짜
            var inputDate by remember{ mutableStateOf(TextFieldValue(""))} // 관찰 가능한 값 생성
            OutlinedTextField(
                value = inputDate, // 해당 값이 업데이트 되면 TextField 업데이트
                trailingIcon = { Icon(imageVector = Icons.Filled.CalendarToday , contentDescription = "CalendarIcon")},
                label = { Text(text = "Date") },
                onValueChange = { newText -> // 사용자가 텍스트를 입력할 때 실행
                    inputDate = newText
                },
                modifier = Modifier
                    .padding(30.dp , 20.dp , 30.dp , 0.dp)
                    .fillMaxWidth(),
                singleLine = true
            )

            // 제목
            var inputTitle by remember{ mutableStateOf(TextFieldValue(""))} // 관찰 가능한 값 생성
            OutlinedTextField(
                value = inputTitle, // 해당 값이 업데이트 되면 TextField 업데이트
                label = { Text(text = "Title") },
                onValueChange = { newText -> // 사용자가 텍스트를 입력할 때 실행
                    inputTitle = newText
                },
                modifier = Modifier
                    .padding(30.dp , 10.dp , 30.dp , 0.dp)
                    .fillMaxWidth(),
                singleLine = true
            )

            // 내용
            var inputContent by remember{ mutableStateOf(TextFieldValue(""))} // 관찰 가능한 값 생성
            OutlinedTextField(
                value = inputContent, // 해당 값이 업데이트 되면 TextField 업데이트
                label = { Text(text = "Content") },
                onValueChange = { newText -> // 사용자가 텍스트를 입력할 때 실행
                    inputContent = newText
                },
                modifier = Modifier
                    .padding(30.dp , 10.dp , 30.dp , 0.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                // 취소하기
                TextButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(
                        text = "취소하기",
                        color = mainColor,
                        style = TextStyle(fontSize = 18.sp, fontFamily = YUniverse),
                        modifier = Modifier.padding(2.dp),
                        textAlign = TextAlign.Center
                    )
                }

                // 등록하기
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = mainColor)
                ) {
                    Text(
                        text = "등록하기",
                        color = Color.White,
                        style = TextStyle(fontSize = 18.sp, fontFamily = YUniverse),
                        modifier = Modifier.padding(2.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddEditNotePreView(){
    MyBlueTheme {
        AddEditNoteScreen(rememberNavController(), "소설")
    }
}