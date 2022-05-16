package za.ac.cput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.ac.cput.screens.Modules
import za.ac.cput.screens.PersonalDetails
import za.ac.cput.screens.Welcome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Welcome.route,
    ) {
        composable(NavRoutes.Welcome.route) {
            Welcome(navController = navController)
        }

        composable(NavRoutes.PersonalDetails.route) {
            PersonalDetails(navController = navController)
        }

        composable(NavRoutes.Modules.route) {
            Modules(navController = navController)
        }

    }
}
