package com.company.attendance.utils

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import kotlinx.coroutines.delay
import androidx.compose.animation.*

object NavigationHelper {
    
    /**
     * Performs smooth navigation with optional delay for better UX
     */
    suspend fun navigateWithDelay(
        navController: NavController,
        route: String,
        delayMs: Long = 500L,
        clearBackStack: Boolean = true
    ) {
        delay(delayMs)
        
        val navOptions = if (clearBackStack) {
            NavOptions.Builder()
                .setPopUpTo(navController.graph.startDestinationId, inclusive = true)
                .build()
        } else {
            null
        }
        
        navController.navigate(route, navOptions)
    }
    
    /**
     * Check if user should go to onboarding or dashboard
     */
    fun determineNextDestination(
        isAuthenticated: Boolean,
        isOnboarded: Boolean
    ): String {
        return when {
            !isAuthenticated -> "login"
            !isOnboarded -> "onboarding"
            else -> "dashboard"
        }
    }
    
    /**
     * Navigate based on authentication and onboarding state
     */
    suspend fun navigateBasedOnState(
        navController: NavController,
        isAuthenticated: Boolean,
        isOnboarded: Boolean,
        currentRoute: String? = null
    ) {
        val destination = determineNextDestination(isAuthenticated, isOnboarded)
        
        // Avoid navigating to the same route
        if (currentRoute != destination) {
            navigateWithDelay(
                navController = navController,
                route = destination,
                delayMs = if (destination == "dashboard") 800L else 300L,
                clearBackStack = true
            )
        }
    }
    
    /**
     * Creates smooth slide animations for navigation
     */
    fun createSlideEnterTransition() = androidx.compose.animation.slideInHorizontally(
        initialOffsetX = { it }
    )
    
    fun createSlideExitTransition() = androidx.compose.animation.slideOutHorizontally(
        targetOffsetX = { -it }
    )
    
    /**
     * Creates fade transition for navigation
     */
    fun createFadeEnterTransition() = androidx.compose.animation.fadeIn()
    
    fun createFadeExitTransition() = androidx.compose.animation.fadeOut()
}