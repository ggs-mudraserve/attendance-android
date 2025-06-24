package com.company.attendance.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000b\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0086@\u00a2\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/company/attendance/utils/NavigationHelper;", "", "()V", "createFadeTransition", "error/NonExistentClass", "()Lerror/NonExistentClass;", "createSlideTransition", "determineNextDestination", "", "isAuthenticated", "", "isOnboarded", "navigateBasedOnState", "", "navController", "Landroidx/navigation/NavController;", "currentRoute", "(Landroidx/navigation/NavController;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateWithDelay", "route", "delayMs", "", "clearBackStack", "(Landroidx/navigation/NavController;Ljava/lang/String;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class NavigationHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.utils.NavigationHelper INSTANCE = null;
    
    private NavigationHelper() {
        super();
    }
    
    /**
     * Performs smooth navigation with optional delay for better UX
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object navigateWithDelay(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String route, long delayMs, boolean clearBackStack, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Check if user should go to onboarding or dashboard
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String determineNextDestination(boolean isAuthenticated, boolean isOnboarded) {
        return null;
    }
    
    /**
     * Navigate based on authentication and onboarding state
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object navigateBasedOnState(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, boolean isAuthenticated, boolean isOnboarded, @org.jetbrains.annotations.Nullable()
    java.lang.String currentRoute, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Creates smooth slide animations for navigation
     */
    @org.jetbrains.annotations.NotNull()
    public final error.NonExistentClass createSlideTransition() {
        return null;
    }
    
    /**
     * Creates fade transition for navigation
     */
    @org.jetbrains.annotations.NotNull()
    public final error.NonExistentClass createFadeTransition() {
        return null;
    }
}