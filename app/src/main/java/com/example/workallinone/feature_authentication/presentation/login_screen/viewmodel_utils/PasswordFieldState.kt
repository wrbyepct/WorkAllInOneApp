package com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils

import androidx.compose.ui.focus.FocusState

data class PasswordFieldState(
    val isVisible: Boolean = false,
    val password: String = ""
)