package com.heiwalocal.fullstackapplicantandroidapp.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter

@Composable
fun AppBottomNavBar(
    navController: NavHostController
) {
    BottomNavBar(
        items = listOf(
            BottomNavItem(
                name = "Главная",
                route = NavigationRouter.Home.route,
                icon = Icons.Rounded.Home
            ),
            BottomNavItem(
                name = "Отклики",
                route = NavigationRouter.JobsPostings.route,
                icon = Icons.Rounded.Message
            ),
            BottomNavItem(
                name = "Резюме",
                route = NavigationRouter.Resumes.route,
                icon = Icons.Rounded.List
            ),
            BottomNavItem(
                name = "Профиль",
                route = NavigationRouter.Profile.route,
                icon = Icons.Rounded.AccountCircle
            ),
        ),
        navController = navController,
        onItemClick = {
            navController.navigate(it.route)
        }
    )
}