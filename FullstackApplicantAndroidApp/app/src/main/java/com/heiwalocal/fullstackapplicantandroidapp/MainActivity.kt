package com.heiwalocal.fullstackapplicantandroidapp

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancydetail.VacancyDetailScreen
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.FullstackApplicantAndroidAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )

        setContent {
            FullstackApplicantAndroidAppTheme {
//                LoginScreen()
//                StartScreen()
//                SignUpScreen()
//                HomeScreen()
//                SearchScreen()
                VacancyDetailScreen()
            }
        }
    }
}
