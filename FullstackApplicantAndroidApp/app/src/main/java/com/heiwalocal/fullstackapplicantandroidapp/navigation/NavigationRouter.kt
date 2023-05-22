package com.heiwalocal.fullstackapplicantandroidapp.navigation

sealed class NavigationRouter(val route: String) {
    object Start: NavigationRouter("start")
    object Login: NavigationRouter("login")
    object SignUp: NavigationRouter("signup")
    object Home: NavigationRouter("home")
    object Search: NavigationRouter("search")
    object VacancyDetail: NavigationRouter("vacancydetail")
    object Profile: NavigationRouter("profile")
    object Resumes: NavigationRouter("resumes")
    object AddResume: NavigationRouter("addresume")
    object JobsPostings: NavigationRouter("jobspostings")
    object ResumeDetail: NavigationRouter("resumedetail")
}