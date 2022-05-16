package za.ac.cput.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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




@Composable
fun PersonalDetails(navController: NavHostController) {
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
        Details(navController)

    }
}


@Composable
fun Details(navController: NavHostController){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Box(
            modifier = Modifier
                .background(Color(0xA4FFFFFF))
                .padding(10.dp),


            ){
            Text(
                text = stringResource(R.string.Details),
                color = Color.Black,
                style = MaterialTheme.typography.subtitle2,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current

        Button(
            onClick = {navController.navigate(NavRoutes.Modules.route)},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
            shape = RoundedCornerShape(50),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp
            )

        ) {

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )

            Text(
                text = "CURRENT MODULES",
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.subtitle2,
                fontSize = 25.sp
            )

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {navController.navigate(NavRoutes.Welcome.route)},
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
}


