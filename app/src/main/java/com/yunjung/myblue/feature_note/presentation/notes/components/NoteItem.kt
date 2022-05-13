package com.yunjung.myblue.feature_note.presentation.notes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.R
import com.yunjung.myblue.feature_note.domain.model.Note
import com.yunjung.myblue.ui.theme.MyBlueTheme
import com.yunjung.myblue.ui.theme.polaroid

@Composable
fun NoteItem (
    note : Note
){
    Column(
        modifier = Modifier
            .padding(8.dp) // Outer Padding
            .clickable(
                onClick = {

                }
            )
            .background(polaroid)
            .height(255.dp)
            .width(180.dp)
            .padding(12.dp) // Inner Padding
    ) {
        // 이미지
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // 날짜
        Text(
            text = "${note.date[0]}년 ${note.date[1]}월 ${note.date[2]}일",
            fontSize = 10.sp,
            modifier = Modifier
                .padding(0.dp, 2.dp, 2.dp, 0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End
        )

        // 제목
        Text(
            text = "${note.title}",
            fontSize = 15.sp,
            modifier = Modifier
                .padding(0.dp, 8.dp, 0.dp, 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

// 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val note = Note(
        id = 1,
        drawerName = "와인바",
        image = "",
        title = "제목",
        content = "내용",
        date = listOf(2022, 5, 12)
    )

    MyBlueTheme {
        NoteItem(
            note = note
        )
    }
}