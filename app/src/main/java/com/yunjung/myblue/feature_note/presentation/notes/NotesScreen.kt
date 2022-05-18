package com.yunjung.myblue.feature_note.presentation.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.yunjung.myblue.ui.theme.YUniverse
import com.yunjung.myblue.ui.theme.mainColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunjung.myblue.feature_note.domain.model.Note
import com.yunjung.myblue.feature_note.presentation.notes.components.NoteItem
import com.yunjung.myblue.feature_note.presentation.util.Screen
import com.yunjung.myblue.ui.theme.MyBlueTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesScreen(
    navController: NavController,
    name : String
) {
    var dropDownMenuExpanded by remember { mutableStateOf(false) }

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
                            // 드롭다운 메뉴를 펼친다.
                            dropDownMenuExpanded = true
                         }
                    ) {
                        Icon(imageVector = Icons.Filled.MoreVert , contentDescription = "More")

                        // 드롭다운 메뉴를 그린다.
                        DropdownMenu(
                            expanded = dropDownMenuExpanded,
                            onDismissRequest = { dropDownMenuExpanded = false },
                            modifier = Modifier.width(165.dp)
                        ) {
                            DropdownMenuItem(
                                onClick = {
                                    // 삭제하기 아이템 클릭시 이벤트
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "DeleteIcon",
                                    modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)
                                )
                                Text("서랍 삭제하기")
                            }
                        }

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
               Icon(imageVector = Icons.Default.Create , contentDescription = "Note Add", tint = Color.White)
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