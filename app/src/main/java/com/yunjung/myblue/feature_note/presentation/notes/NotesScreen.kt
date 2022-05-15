package com.yunjung.myblue.feature_note.presentation.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.yunjung.myblue.ui.theme.YUniverse
import com.yunjung.myblue.ui.theme.mainColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunjung.myblue.feature_note.domain.model.Note
import com.yunjung.myblue.feature_note.presentation.notes.components.NoteItem
import com.yunjung.myblue.feature_note.presentation.util.Screen
import com.yunjung.myblue.ui.theme.MyBlueTheme
import com.yunjung.myblue.ui.theme.pointColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesScreen(
    navController: NavController,
    name : String
) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = name,
                        style = TextStyle(fontSize = 20.sp, fontFamily = YUniverse)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp() // 뒤로가기
                        }) {
                            Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "backIcon")
                        }
                },
                actions = {
                    IconButton(
                        onClick = {
                            // IconButton Click Event
                         }
                    ) {
                        Icon(imageVector = Icons.Filled.MoreVert , contentDescription = "More")
                    }
                },
                backgroundColor = mainColor,
                contentColor = Color.White
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditNoteScreen.route + "/$name")
                },
                backgroundColor = mainColor
            ) {
               Icon(imageVector = Icons.Default.Add , contentDescription = "Note Add", tint = Color.White)
            }
        }
    ) {
        // 뷰모델 작업
        val note = Note(
            id = 1,
            drawerName = "소설",
            image = "",
            title = "제목",
            content = "내용",
            date = listOf(2022, 5, 12)
        )
        val notes = listOf<Note>(note, note, note, note, note, note)

        /* 화면 구성 */
        LazyVerticalGrid(
            cells =  GridCells.Adaptive(minSize = 180.dp)
        ){
            items(notes){ note ->
                NoteItem(note = note)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesPreview(){
    MyBlueTheme {
        NotesScreen(navController = rememberNavController(), name = "와인바")
    }
}