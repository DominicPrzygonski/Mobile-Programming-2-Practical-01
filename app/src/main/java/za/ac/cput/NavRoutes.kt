package za.ac.cput

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("Welcome")
    object PersonalDetails : NavRoutes("PersonalDetails")
    object Modules : NavRoutes("Modules")
}
