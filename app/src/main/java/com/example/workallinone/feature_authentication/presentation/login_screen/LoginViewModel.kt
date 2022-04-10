package com.example.workallinone.feature_authentication.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils.LoginEvent
import com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils.PasswordFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {


    private val _usernameState = mutableStateOf(PasswordFieldState())
    val usernameState: State<PasswordFieldState> = _usernameState

    private val _passwordState = mutableStateOf(PasswordFieldState())
    val passwordState: State<PasswordFieldState> = _passwordState


    fun onEvent(event: LoginEvent) {
        when(event) {

            is LoginEvent.UsernameEntered -> {
                _usernameState.value = usernameState.value.copy(
                    password = event.username
                )
            }
            is LoginEvent.ClearBtnClicked -> {
                _usernameState.value = usernameState.value.copy(
                    password = ""
                )
            }
            is LoginEvent.PwVisibleBtnClicked -> {
                _passwordState.value = passwordState.value.copy(
                    isVisible = !passwordState.value.isVisible
                )
            }
            is LoginEvent.PasswordEntered -> {
                _passwordState.value = passwordState.value.copy(
                    password = event.password
                )
            }

        }
    }
}