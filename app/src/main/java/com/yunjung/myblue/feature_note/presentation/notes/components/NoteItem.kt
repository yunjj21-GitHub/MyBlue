package com.yunjung.myblue.feature_note.presentation.notes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yunjung.myblue.R
import com.yunjung.myblue.feature_note.domain.model.Note
import com.yunjung.myblue.ui.theme.MyBlueTheme

@Composable
fun NoteItem (
    note : Note ,
    onClick: () -> Unit // 파라미터로 함수를 받는다. (매개변수 없음, 반환값 없음)
){
    Column( // 세로로 쌓는다.
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick) // 클릭 시 물결 효과를 표시한다.
            .padding(16.dp)
    ) {
        // 이미지
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // 날짜
        Row( // 가로로 쌓는다.
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Text(
                text = "${note.date[0]}년 ${note.date[1]}월 ${note.date[2]}일",
                style = MaterialTheme.typography.caption,
            )
        }

        // 제목
        Row( // 가로로 쌓는다.
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 0.dp)
        ){
            Text(
                text = "${note.title}",
                style = MaterialTheme.typography.h4,
                maxLines = 1
            )
        }
    }
}

// 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val note = Note(
        id = 1,
        image = "",
        title = "제목",
        content = "내용",
        date = listOf(2022, 5, 12)
    )

    MyBlueTheme {
        NoteItem(
            note = note,
            onClick = {

            }
        )
    }
}