package com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils



sealed class LoginEvent {
    data class UsernameEntered(val username: String): LoginEvent()
    object ClearBtnClicked: LoginEvent()
    data class PasswordEntered(val password: String): LoginEvent()
    object PwVisibleBtnClicked: LoginEvent()
}