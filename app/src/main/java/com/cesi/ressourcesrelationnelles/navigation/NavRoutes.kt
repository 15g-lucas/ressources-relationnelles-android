package com.cesi.ressourcesrelationnelles.navigation

sealed class NavRoutes(val route: String) {
    data object Dashboard : NavRoutes("dashboard")
    data object Login : NavRoutes("login")
    data object Register : NavRoutes("register")
    data object Profile : NavRoutes("profile/{userId}")
    data object CreatePost : NavRoutes("createPost")
    data object Category : NavRoutes("category")
    data object CategoryDashboard : NavRoutes("categoryDashboard/{categoryId}/{categoryTitle}")
    data object Relation : NavRoutes("relation/{relationTypeId}")
}
