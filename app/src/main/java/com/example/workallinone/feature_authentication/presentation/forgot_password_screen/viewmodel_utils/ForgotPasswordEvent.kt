package com.example.workallinone.feature_authentication.presentation.forgot_password_screen.viewmodel_utils

sealed class ForgotPasswordEvent{
    object EmailEntered: ForgotPasswordEvent()
}
