package com.yunjung.myblue.feature_note.domain.model

import android.graphics.Bitmap

data class Note(
    val id : Int? = null,
    val drawerName : String,
    val image : String, // Bitmap
    val title : String,
    val content : String,
    val date : List<Int>
)