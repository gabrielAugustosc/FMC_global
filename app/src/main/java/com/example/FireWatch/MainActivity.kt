package com.globalSolution.FireWatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.globalSolution.FireWatch.ui.screen.DashboardScreen
import com.globalSolution.FireWatch.ui.screen.LoginScreen
import com.globalSolution.FireWatch.ui.screen.ProfileScreen
import com.globalSolution.FireWatch.ui.screen.SignUpScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginClick = { navController.navigate("dashboard") },
                onNavigateToSignUp = { navController.navigate("signup") }
            )
        }
        composable("signup") {
            SignUpScreen(
                onNavigateBack = { navController.popBackStack() },
                onSignUpClick = { navController.navigate("dashboard") }
            )
        }
        composable("dashboard") {
            DashboardScreen(
                onNavigateToProfile = { navController.navigate("profile") }
            )
        }
        composable("profile") {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo(0) // Limpa o histórico ao sair da conta
                    }
                }
            )
        }
    }
}