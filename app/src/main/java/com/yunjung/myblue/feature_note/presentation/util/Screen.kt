package com.yunjung.myblue.feature_note.presentation.util

sealed class Screen(val route : String){
    object DrawerScreen : Screen("drawer_screen")
    object NotesScreen : Screen("notes_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
}