package com.example.workallinone.feature_authentication.presentation.forgot_password_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.workallinone.feature_authentication.presentation.forgot_password_screen.viewmodel_utils.ForgotPasswordEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    
) : ViewModel() {
    
    private val _emailState = mutableStateOf("")
    val usernameState: State<String> = _emailState

    fun onEvent(event: ForgotPasswordEvent) {
        when(event) {
            is ForgotPasswordEvent.EmailEntered -> {

            }
        }
    }
    
}