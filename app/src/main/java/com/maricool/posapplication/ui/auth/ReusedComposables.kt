package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maricool.posapplication.ui.theme.typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleInputField(label: String, hint: String) {
    val state = remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    Column() {
        Text(
            label, style = typography.bodySmall,
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
                    text = hint, style = typography.bodySmall,
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
fun SinglePasswordField(label: String, hint: String) {
    val state = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    Column {
        Text(
            label, style = typography.bodySmall, fontSize = 15.sp
        )

        TextField(
            value = state.value,
            singleLine = true,
            onValueChange = { state.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
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
                    text = hint,
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
                    style = typography.bodySmall,
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
fun DefaultButtonWhite(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface),
    ) {
        Text(
            text = text,
            style = typography.bodyMedium,
            color = MaterialTheme.colorScheme.surface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun TopBackButtonComposable(onClick: () -> Unit, text: String) {
    Box(modifier = Modifier
        .fillMaxWidth()) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            onClick()
                        }
                )
                Text(
                    text = text,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = typography.bodyMedium
                )
            }
            Divider(color = Color.LightGray.copy(alpha = 0.2f), thickness = 1.dp)
        }
    }
}
