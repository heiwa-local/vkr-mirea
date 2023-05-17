package com.heiwalocal.fullstackapplicantandroidapp

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpScreen
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.FullstackApplicantAndroidAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setContent {
            FullstackApplicantAndroidAppTheme {
                SignUpScreen()
//                StartScreen()
            }
        }
    }
}
