package rs.dc.budihuman.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import rs.dc.budihuman.ui.navigation.Screen
import rs.dc.budihuman.ui.screen.details.DetailScreen
import rs.dc.budihuman.ui.screen.main.MainScreen
import rs.dc.budihuman.ui.screen.main.MainScreenViewModel

@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            val viewModel = hiltViewModel<MainScreenViewModel>()
            MainScreen(context = context, navController = navController, viewModel = viewModel)
        }

        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            DetailScreen(name = it.arguments?.getString("name"))
        }
    }
}


