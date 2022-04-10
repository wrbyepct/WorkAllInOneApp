package com.example.workallinone.feature_authentication.presentation.register_screen.viewmodel_utils

sealed class RegistrationEvent {
    data class EmailEntered(val email: String): RegistrationEvent()
    object ClearEmailField: RegistrationEvent()
    data class NameEntered(val name: String): RegistrationEvent()
    object ClearNameField: RegistrationEvent()
    data class PasswordEntered(val password: String): RegistrationEvent()
    object PasswordVisibleToggle: RegistrationEvent()
    data class ConfirmPwEntered(val confirmPassword: String): RegistrationEvent()
    object ConfirmPwVisibleToggle: RegistrationEvent()
}
