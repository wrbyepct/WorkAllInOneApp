package com.example.workallinone.feature_authentication.presentation.login_screen

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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workallinone.core.*
import com.example.workallinone.feature_authentication.presentation.login_screen.viewmodel_utils.LoginEvent


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    /**
     *  test states
     */
    val usernameState = viewModel.usernameState.value

    val passwordState = viewModel.passwordState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 70.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /**
         *  Username field
         */
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = usernameState.password,
            onValueChange = {
                viewModel.onEvent(LoginEvent.UsernameEntered(it))
            },
            label = { Text(USERNAME) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            ),
            singleLine = true,
            trailingIcon = {
                if (usernameState.password.isNotBlank())
                    IconButton(
                        onClick = {
                            viewModel.onEvent(LoginEvent.ClearBtnClicked)
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
         * password
         */
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordState.password,
            onValueChange = { viewModel.onEvent(LoginEvent.PasswordEntered(it)) },
            label = { Text(PASSWORD) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black,
                unfocusedLabelColor = Color.LightGray
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordState.isVisible)
                                        VisualTransformation.None
                                   else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = { viewModel.onEvent(LoginEvent.PwVisibleBtnClicked) }
                ) {
                    Icon(
                        imageVector = if (passwordState.isVisible)
                                           Icons.Default.Visibility
                                      else Icons.Default.VisibilityOff,
                        contentDescription = "Visibility",
                        tint = MaterialTheme.colors.surface
                    )
                }
            }
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