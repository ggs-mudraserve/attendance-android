package com.company.attendance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.company.attendance.ui.screens.dashboard.DashboardScreen
import com.company.attendance.ui.screens.history.HistoryScreen
import com.company.attendance.ui.screens.login.LoginScreen
import com.company.attendance.ui.screens.onboarding.OnboardingScreen
import com.company.attendance.ui.screens.settings.SettingsScreen

@Composable
fun AttendanceNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            com.company.attendance.ui.screens.login.EnhancedLoginScreen(
                viewModel = hiltViewModel<com.company.attendance.ui.screens.login.EnhancedLoginViewModel>(),
                onLoginSuccess = { isFirstTime ->
                    if (isFirstTime) {
                        navController.navigate("onboarding") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        navController.navigate("dashboard") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                }
            )
        }
        
        composable("onboarding") {
            OnboardingScreen(
                viewModel = hiltViewModel(),
                onOnboardingComplete = {
                    navController.navigate("dashboard") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }
        
        composable("dashboard") {
            DashboardScreen(
                viewModel = hiltViewModel(),
                onNavigateToHistory = {
                    navController.navigate("history")
                },
                onNavigateToSettings = {
                    navController.navigate("settings")
                }
            )
        }
        
        composable("history") {
            HistoryScreen(
                viewModel = hiltViewModel(),
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("settings") {
            SettingsScreen(
                viewModel = hiltViewModel(),
                onBackClick = {
                    navController.popBackStack()
                },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}