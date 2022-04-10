package com.example.workallinone.feature_authentication.presentation.register_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workallinone.core.*
import com.example.workallinone.feature_authentication.presentation.forgot_password_screen.viewmodel_utils.ForgotPasswordEvent
import com.example.workallinone.feature_authentication.presentation.login_screen.LoginViewModel
import com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils.LoginEvent
import com.example.workallinone.feature_authentication.presentation.main_screen.components.PasswordTextField
import com.example.workallinone.feature_authentication.presentation.register_screen.viewmodel_utils.RegistrationEvent

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    /**
     *  test states
     */
    val emailState = viewModel.email.value
    val nameState = viewModel.name.value
    val passwordState = viewModel.passwordState.value
    val confirmPwState = viewModel.confirmPwState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 70.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        /**
         *  Email field
         */
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = emailState.email,
            onValueChange = {
                viewModel.onEvent(RegistrationEvent.EmailEntered(it))
            },
            label = { Text(EMAIL) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            ),
            singleLine = true,
            trailingIcon = {
                if (emailState.email.isNotBlank())
                    IconButton(
                        onClick = {
                            viewModel.onEvent(RegistrationEvent.ClearEmailField)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear",
                            tint = MaterialTheme.colors.surface,
                        )
                    }
            },
        )

        /**
         * Password field
         */
        PasswordTextField(
            password = passwordState.password,
            label = PASSWORD,
            isVisible = passwordState.isVisible,
            onVisibleToggle = { viewModel.onEvent(RegistrationEvent.PasswordVisibleToggle) },
            onPasswordEntered = { viewModel.onEvent(RegistrationEvent.PasswordEntered(it)) }
        )
        /**
         * Confirmed Password field
         */
        PasswordTextField(
            password = confirmPwState.password,
            label = CONFIRM_PASSWORD,
            isVisible = passwordState.isVisible,
            onVisibleToggle = { viewModel.onEvent(RegistrationEvent.ConfirmPwVisibleToggle) },
            onPasswordEntered = { viewModel.onEvent(RegistrationEvent.ConfirmPwEntered(it)) }
        )


        Spacer(modifier = Modifier.height(8.dp))

        /**
         * Sign-in button
         */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(MaterialTheme.colors.primary)
                .padding(12.dp),
        ) {
            Text(
                text = SIGN_IN,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        /**
         *  Account buttons
         */
        /**
         *  Account buttons
         */
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                modifier = Modifier
                    .clickable{

                    },
                text = REGISTRATION,
                color = Color.LightGray
            )

            Text(
                text = FORGOT_PASSWORD,
                color = Color.LightGray
            )
        }
    }
}