package com.example.workallinone.feature_authentication.presentation.register_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils.PasswordFieldState
import com.example.workallinone.feature_authentication.presentation.register_screen.viewmodel_utils.EmailState
import com.example.workallinone.feature_authentication.presentation.register_screen.viewmodel_utils.RegistrationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(

) : ViewModel() {

    private val _email = mutableStateOf(EmailState())
    val email: State<EmailState> = _email

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _passwordState = mutableStateOf(PasswordFieldState())
    val passwordState: State<PasswordFieldState> = _passwordState

    private val _confirmPwState = mutableStateOf(PasswordFieldState())
    val confirmPwState: State<PasswordFieldState> = _confirmPwState

    fun onEvent(event: RegistrationEvent) {
        when(event) {
            is RegistrationEvent.EmailEntered -> {
                _email.value = email.value.copy(
                    email = event.email
                )
            }
            is RegistrationEvent.ClearEmailField -> {
                _email.value = email.value.copy(
                    email = ""
                )
            }
            is RegistrationEvent.NameEntered -> {
                _name.value = event.name
            }
            is RegistrationEvent.ClearNameField -> {
                _name.value = ""
            }
            is RegistrationEvent.PasswordEntered -> {
                _passwordState.value = passwordState.value.copy(
                    password = event.password
                )
            }
            is RegistrationEvent.PasswordVisibleToggle -> {
                _passwordState.value = passwordState.value.copy(
                    isVisible = !passwordState.value.isVisible
                )
            }
            is RegistrationEvent.ConfirmPwEntered -> {
                _confirmPwState.value = confirmPwState.value.copy(
                    password = event.confirmPassword
                )
            }
            is RegistrationEvent.ConfirmPwVisibleToggle -> {
                _confirmPwState.value = confirmPwState.value.copy(
                    isVisible = !confirmPwState.value.isVisible
                )
            }
        }
    }
}