package com.cesi.ressourcesrelationnelles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cesi.ressourcesrelationnelles.ui.screen.category.CategoryScreen
import com.cesi.ressourcesrelationnelles.ui.screen.categoryDashboard.CategoryDashboardScreen
import com.cesi.ressourcesrelationnelles.ui.screen.dashboard.DashboardScreen
import com.cesi.ressourcesrelationnelles.ui.screen.login.LoginScreen
import com.cesi.ressourcesrelationnelles.ui.screen.profile.ProfileScreen
import com.cesi.ressourcesrelationnelles.ui.screen.register.RegisterScreen
import com.cesi.ressourcesrelationnelles.ui.screen.relation.RelationScreen


@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(NavRoutes.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(
            NavRoutes.Dashboard.route,
//            arguments = listOf(
//            navArgument("userId") { type = NavType.StringType }
//        )
        ) {
//            backStackEntry ->
//            val userId = backStackEntry.arguments?.getString("userId")
            DashboardScreen(navController = navController)
        }
        composable(
            NavRoutes.Profile.route,
        ) {
            ProfileScreen(navController = navController)
        }
        composable(NavRoutes.Category.route) {
            CategoryScreen(navController = navController)
        }
        composable(
            NavRoutes.CategoryDashboard.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("categoryTitle") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")
            val categoryTitle = backStackEntry.arguments?.getString("categoryTitle")
            CategoryDashboardScreen(
                navController = navController,
                categoryId = categoryId!!,
                categoryTitle = categoryTitle!!
            )
        }
        composable(
            NavRoutes.Relation.route,
            arguments = listOf(
                navArgument("relationTypeId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val relationTypeId = backStackEntry.arguments?.getInt("relationTypeId")
            RelationScreen(relationTypeId = relationTypeId!!, navController = navController)
        }

    }
}

