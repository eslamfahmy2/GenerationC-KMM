package com.example.generationckmm.android.presentation.components.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.generationckmm.android.presentation.ui.CarsDetailScreen
import com.example.generationckmm.android.presentation.ui.MainSearchScreen
import com.example.generationckmm.android.utils.fromJson
import com.google.gson.Gson


sealed class Destinations(
    val route: String
) {
    object HomeScreen : Destinations("home")
    object CarDetailsScreen : Destinations("details/{car}") {
        const val arg = "car"
        fun generateRoute(arg: String) = "details/${arg}"
    }
}

// Adds Main screen to NavGraphBuilder
fun NavGraphBuilder.homeDestination(navController: NavHostController) {
    composable(Destinations.HomeScreen.route) {
        // The ViewModel as a screen level state holder produces the screen
        // UI state and handles business logic for the screen
        MainSearchScreen { car ->
            //work around to send objects data -serializable or parcelables- as string
            //due to api level restrictions and argument buffer size
            Gson().toJson(car)?.let {
                navController.navigate(Destinations.CarDetailsScreen.generateRoute(it))
            }
        }
    }
}

// Add Car Details screen to Nav Graph Builder
fun NavGraphBuilder.carDetailsDestination(navController: NavHostController) {
    composable(
        route = Destinations.CarDetailsScreen.route,
        arguments = listOf(
            navArgument(Destinations.CarDetailsScreen.arg) { type = NavType.StringType }
        )
    ) { NavBackStackEntry ->
        NavBackStackEntry.arguments?.getString(Destinations.CarDetailsScreen.arg)?.let {
            CarsDetailScreen(
                onBack = { navController.popBackStack() },
                car = Gson().fromJson(it)
            )
        }
    }
}

