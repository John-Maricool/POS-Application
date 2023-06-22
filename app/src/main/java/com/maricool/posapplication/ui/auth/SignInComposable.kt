package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maricool.posapplication.ui.theme.typography

@Composable
fun SignInComposable() {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(
                "Welcome Back",
                style = typography.bodyLarge,
                color = MaterialTheme.colorScheme.surface
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Proceed with your valid details",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(30.dp))
            SingleInputField()
            Spacer(modifier = Modifier.height(10.dp))
            SinglePasswordField()
            Spacer(modifier = Modifier.height(10.dp))
            Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Forgot Password?",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.surface,
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            DefaultButton(text = "Login to account") {

            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                IDontHaveAnAccount()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleInputField() {
    val state = remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    Column() {
        Text(
            "Email address", style = typography.bodySmall,
            fontSize = 15.sp
        )
        TextField(
            value = state.value,
            singleLine = true,
            onValueChange = { state.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, if (isFocused) Color.DarkGray else Color.LightGray),
                    shape = RoundedCornerShape(5.dp)
                ),
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    text = "john@gmail.com", style = typography.bodySmall,
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                containerColor = Color(0xFFF7F5F5)
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SinglePasswordField() {
    val state = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    Column {
        Text(
            "Password", style = typography.bodySmall, fontSize = 15.sp
        )

        TextField(
            value = state.value,
            singleLine = true,
            onValueChange = { state.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, if (isFocused) Color.DarkGray else Color.LightGray),
                    shape = RoundedCornerShape(5.dp)
                )
                .toggleable(
                    passwordVisibility.value,
                    onValueChange = { passwordVisibility.value = it },
                ),
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    text = "john@gmail.com",
                    style = typography.bodySmall,
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                containerColor = Color(0xFFF7F5F5)
            ),
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Text(
                    text = if (passwordVisibility.value) "HIDE" else "SHOW",
                    modifier = Modifier.clickable {
                        passwordVisibility.value = !passwordVisibility.value
                    },
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 15.sp
                )
            }
        )
    }
}

@Composable
fun DefaultButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Text(
            text = text,
            style = typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun IDontHaveAnAccount() {
    Row {
        Text(
            text = "I don't have an account? ",
            style = typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = "Create one",
            style = typography.bodyMedium,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.surface,
        )
    }
}