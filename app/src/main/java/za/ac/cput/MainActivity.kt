package za.ac.cput

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Welcome()
        }
    }
}

@Composable
fun Welcome() {
    Column(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.linearGradient(listOf(androidx.compose.ui.graphics.Color.Cyan,
                androidx.compose.ui.graphics.Color.Red))
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Welcome to My Jetpack Compose Journey",

            color = androidx.compose.ui.graphics.Color.Black,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        val visible:MutableState<Boolean> = remember{ mutableStateOf(false)}

        ShowDialog(visible = visible)

        Button(
            onClick = {visible.value = true},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
            shape = RoundedCornerShape(50),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp
            )

        ) {

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )

            Text(
                text = "INFO",
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.subtitle2,
                fontSize = 30.sp
            )

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current

        Button(
            onClick = {context.startActivity(Intent(context, PersonalDetails::class.java))},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
            shape = RoundedCornerShape(50),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp
            )

        ) {

            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Person",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )

            Text(
                text = "START JOURNEY",
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.subtitle2,
                fontSize = 30.sp
            )

            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Person",
                Modifier
                    .padding(2.dp)
                    .size(40.dp),
            )
        }

    }
}

@Composable
fun ShowDialog(visible: MutableState<Boolean>){

    if(visible.value){
        AlertDialog(

            onDismissRequest = { visible.value = false },
            title = { Text(text = stringResource(R.string.title),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold ) },
            text = { Text(text = stringResource(R.string.description),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp)},
            buttons = {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                horizontalArrangement = Arrangement.Center){
                    Button(onClick = { visible.value = false },
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 10.dp
                        )) {
                        Text(text = "CLOSE",
                             color = colorResource(id = R.color.white),)
                    }
                }
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Welcome()
}