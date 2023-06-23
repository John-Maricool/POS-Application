package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maricool.posapplication.ui.theme.typography

@Composable
fun ForgotPasswordComposable(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp), contentAlignment = Alignment.TopCenter) {
        Column {
            Text(
                "To reset your password, please enter your email address",
                style = typography.bodySmall
            )
            Spacer(modifier = Modifier.height(30.dp))
            SingleInputField(label = "Email Address", hint = "eg oracle@gmail.com")
            Spacer(modifier = Modifier.height(30.dp))
            ResetPasswordButton(text = "Reset Password") {
            }
        }
    }
}

@Composable
fun ResetPasswordButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)),
    ) {
        Row(horizontalArrangement = Arrangement.Center) {

        Text(
                text = text,
                style = typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
