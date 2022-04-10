package com.example.workallinone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.workallinone.feature_authentication.presentation.login_screen.LoginScreen
import com.example.workallinone.ui.theme.WorkAllInOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkAllInOneTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
            }
        }
    }
}

