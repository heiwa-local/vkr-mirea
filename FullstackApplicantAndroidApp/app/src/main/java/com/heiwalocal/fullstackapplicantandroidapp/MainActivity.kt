package com.heiwalocal.fullstackapplicantandroidapp

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancydetail.VacancyDetailScreen
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.FullstackApplicantAndroidAppTheme

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private val searchViewModel by viewModel<SearchViewModel>()

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
                SearchScreen(viewModel = searchViewModel)
//                VacancyDetailScreen()
            }
        }
    }
}
