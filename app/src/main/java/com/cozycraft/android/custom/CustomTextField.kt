package com.cozycraft.android.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.cozycraft.android.theme.Typography
import com.cozycraft.android.theme.textFieldBorderColor
import com.cozycraft.android.theme.textFieldFocusedColor
import com.cozycraft.android.R

@Composable
fun CustomTextField(
    modifier: Modifier,
    label: String,
    isPassword: Boolean? = false,
    keyboardOptions: KeyboardOptions? = KeyboardOptions(keyboardType = KeyboardType.Text),
    isError: Boolean,
    errorText: String? = null,
    onValueChange: (String) -> Unit
) {
    var input by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = input,
        modifier = modifier.fillMaxWidth(),
        onValueChange = {
            input = it.trimStart { it == '0' }
            onValueChange(input)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = textFieldFocusedColor,
            unfocusedBorderColor = textFieldBorderColor
        ),
        visualTransformation = if (isPassword == true && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        textStyle = Typography.bodyMedium,
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = label) },
        trailingIcon = {
            if (isPassword == true) {
                val image = if (passwordVisible)
                    ImageVector.vectorResource(R.drawable.ic_password_toggle_on)
                else ImageVector.vectorResource(R.drawable.ic_password_toggle_off)

                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        },
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = errorText ?: "Error", color = Color.Red)
            }
        }
    )
}