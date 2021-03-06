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
                            // ?????? ??????
                            Image(
                                painter = painterResource(R.drawable.ic_close) ,
                                contentDescription = "CloseIcon" ,
                                modifier = Modifier
                                    .padding(0.dp , 15.dp , 15.dp , 0.dp)
                                    .fillMaxWidth()
                                    .height(35.dp) ,
                                alignment = Alignment.TopEnd
                            )

                            // ?????? ?????????
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
                                text = "?????? ????????????" ,
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
                                text = "????????? ?????????\n????????? ????????? ???????????????." ,
                                style = TextStyle(
                                    color = Color.Gray ,
                                    fontWeight = FontWeight.Bold ,
                                    textAlign = TextAlign.Center
                                ) ,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )

                            // ?????? ????????? ???????????? TextField
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

                            // ?????? ??????
                            Button(
                                onClick = {
                                    // ?????? ?????? ?????? ?????????
                                } ,
                                modifier = Modifier
                                    .padding(30.dp , 10.dp , 30.dp , 10.dp)
                                    .fillMaxWidth()
                                    .height(55.dp)
                            ) {
                                Text(text = "??????")
                            }
                        }
                    }
                }
            }
        },
        scaffoldState = rememberScaffoldState()
    ){
        // ????????? ??????
        var drawerNames = mutableListOf<String>("??????", "?????????", "????????????", "??????", "", "")

        /* ?????? ????????? */
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // ??? ??????
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

            // ??????
            // ?????? ??????
            Spacer(
                modifier = Modifier
                    .padding(32.dp , 0.dp , 32.dp , 0.dp)
                    .clip(RoundedCornerShape(15.dp , 15.dp , 0.dp , 0.dp))
                    .background(mainColor)
                    .fillMaxWidth()
                    .height(25.dp)
            )

            // ?????? ???
            for(name in drawerNames){
                DrawerItem(navController = navController, name = name)
            }

            // ?????? ?????????
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