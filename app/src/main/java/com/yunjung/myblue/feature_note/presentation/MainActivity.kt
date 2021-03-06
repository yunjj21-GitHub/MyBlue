package com.yunjung.myblue.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yunjung.myblue.feature_note.domain.model.Note
import com.yunjung.myblue.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.yunjung.myblue.feature_note.presentation.drawer.DrawerScreen
import com.yunjung.myblue.feature_note.presentation.notes.NotesScreen
import com.yunjung.myblue.feature_note.presentation.util.Screen
import com.yunjung.myblue.ui.theme.MyBlueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBlueTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    // NavHost 생성
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DrawerScreen.route // DrawerScreen을 시작화면으로 지정
                    ){
                        // DrawerScreen(시작화면)으로 이동
                        composable(route = Screen.DrawerScreen.route){
                            DrawerScreen(navController)
                        }

                        // NotesScreen으로 이동
                        composable(
                            route = Screen.NotesScreen.route + "/{name}",
                            arguments = listOf(
                                navArgument("name") {
                                    type = NavType.StringType
                                }
                            )
                        ){ backStackEntry ->
                            NotesScreen(
                                navController = navController,
                                name = backStackEntry.arguments?.getString("name").toString()
                            )
                        }

                        // AddEditScreen으로 이동
                        composable(route = Screen.AddEditNoteScreen.route + "/{name}",
                            arguments = listOf(
                                navArgument("name") {
                                    type = NavType.StringType
                                }
                            )) { backStackEntry ->
                            AddEditNoteScreen(
                                navController = navController ,
                                name = backStackEntry.arguments?.getString("name").toString()
                            )
                        }
                    }
                }
            }
        }
    }
}

// 전체 화면 미리보기
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    var drawerNames = mutableListOf<String>("소설", "카페", "비건식당", "영화", " ")
    val note = Note(
        id = 1,
        drawerName = "소설",
        image = "",
        title = "제목",
        content = "내용",
        date = listOf(2022, 5, 12)
    )
    val notes = listOf<Note>(note, note, note, note, note, note)
    MyBlueTheme {
        // DrawerScreen(drawerNames = drawerNames)
        // NotesScreen(name = "와인바" , notes = notes)
        // AddEditNoteScreen()
    }
}