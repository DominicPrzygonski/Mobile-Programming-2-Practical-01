package za.ac.cput.screens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import za.ac.cput.NavRoutes
import za.ac.cput.R
import za.ac.cput.ui.theme.MyJetPackComposeJourneyTheme
import kotlin.system.exitProcess



@Composable
fun ModuleLayout(name: String, type: String, duration: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Box(
            modifier = Modifier
                .background(Color(0xA4FFFFFF))
                .padding(10.dp),


            ) {
            Text(
                text = "Module Name : $name" +
                        "\nModule Type : $type" +
                        "\nModule Duration : $duration",
                color = Color.Black,
                style = MaterialTheme.typography.subtitle2,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun Modules(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color.Cyan,
                        Color.Red
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(40.dp))
                ModuleLayout(name = "Applications Development Practice 3", type = "Practical", duration = "Year-Round")
            }
            item {
                ModuleLayout(name = "Applications Development Theory 3", type = "Theory", duration = "Year-Round")
            }
            item {
                ModuleLayout(name = "Mobile Programming 2", type = "Practical", duration = "Semester")
            }
            item {
                ModuleLayout(name = "Information Systems 3", type = "Practical", duration = "Year-Round")
            }
            item {
                ModuleLayout(name = "Professional Practice 3", type = "Theory", duration = "Semester")
            }
            item {
                ModuleLayout(name = "Project 3", type = "Practical", duration = "Year-Round")
            }
            item {
                ModuleLayout(name = "Project Management 3", type = "Theory", duration = "Semester")
            }
            item {
                ModuleLayout(name = "Project Presentation 3", type = "Practical", duration = "Year-Round")
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                val context = LocalContext.current

                Button(
                    onClick = {navController.navigate(NavRoutes.PersonalDetails.route)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                    shape = RoundedCornerShape(50),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp
                    )

                ) {

                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        Modifier
                            .padding(2.dp)
                            .size(40.dp),
                    )

                    Text(
                        text = "BACK",
                        color = colorResource(id = R.color.black),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 25.sp
                    )

                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        Modifier
                            .padding(2.dp)
                            .size(40.dp),
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))

                val visible:MutableState<Boolean> = remember{ mutableStateOf(false) }
                LeavingPopup(visible = visible)

                Button(
                    onClick = {visible.value = true},
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                    shape = RoundedCornerShape(50),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp
                    )

                ) {

                    Icon(
                        imageVector = Icons.Filled.ThumbUp,
                        contentDescription = "GOODBYE",
                        Modifier
                            .padding(2.dp)
                            .size(40.dp),
                    )

                    Text(
                        text = "GOODBYE",
                        color = colorResource(id = R.color.black),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 25.sp
                    )

                    Icon(
                        imageVector = Icons.Filled.ThumbUp,
                        contentDescription = "GOODBYE",
                        Modifier
                            .padding(2.dp)
                            .size(40.dp),
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
            }



        }

    }
}

@Composable
fun LeavingPopup(visible: MutableState<Boolean>){

    val activity = (LocalContext.current as? Activity)

    if(visible.value){
        AlertDialog(

            onDismissRequest = { visible.value = false },
            title = { Text(text = "Leaving now?",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold ) },
            text = { Text(text = "",
                textAlign = TextAlign.Center,
                fontSize = 15.sp)},
            buttons = {
                Row(
                    Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.Center)
                {
                    Button(
                        onClick = { visible.value = false },
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp)
                    ) {
                        Text(text = "NO",
                            color = colorResource(id = R.color.white),)
                    }
                    Button(
                        onClick = { exitProcess(0)},
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 10.dp
                        )) {
                        Text(text = "YES",
                            color = colorResource(id = R.color.white),)
                    }
                }
            }
        )
    }

}

