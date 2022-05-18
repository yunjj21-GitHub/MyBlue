package com.yunjung.myblue.feature_note.presentation.drawer.components

import android.app.AlertDialog
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.R
import com.yunjung.myblue.ui.theme.MyBlueTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AddDrawerDialog(){
    Dialog(
        onDismissRequest = {
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
                alignment = TopEnd
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

@Preview(showBackground = true)
@Composable
fun AddDrawerDialogPreview(){
    MyBlueTheme {
        AddDrawerDialog()
    }
}