package com.example.workallinone.feature_authentication.presentation.main_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.workallinone.core.PASSWORD
import com.example.workallinone.feature_authentication.presentation.register_screen.viewmodel_utils.RegistrationEvent


@Composable
fun PasswordTextField(
    password: String,
    label: String,
    isVisible: Boolean = false ,
    onVisibleToggle: () -> Unit,
    onPasswordEntered: (String) -> Unit

) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { onPasswordEntered(it) },
        label = { label },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            unfocusedLabelColor = Color.LightGray
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation = if (isVisible)
            VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = { onVisibleToggle}
            ) {
                Icon(
                    imageVector = if (isVisible)
                        Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = "Visibility",
                    tint = MaterialTheme.colors.surface
                )
            }
        }
    )
}