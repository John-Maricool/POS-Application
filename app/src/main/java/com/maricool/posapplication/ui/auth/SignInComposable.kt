package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.maricool.posapplication.ui.theme.typography
import com.maricool.posapplication.utils.Routes

@Composable
fun SignInComposable(navController: NavHostController) {
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
            SingleInputField("Email Address", "john@gmail.com")
            Spacer(modifier = Modifier.height(10.dp))
            SinglePasswordField("Enter Password", "****")
            Spacer(modifier = Modifier.height(10.dp))
            Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Forgot Password?",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.forgot_password)
                    }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            DefaultButton(text = "Login to account") {
                navController.navigate(Routes.home)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                IDontHaveAnAccount {
                    navController.navigate(Routes.sign_up)
                }
            }
        }
    }
}

@Composable
fun IDontHaveAnAccount(onClick: () -> Unit) {
    Row {
        Text(
            text = "I don't have an account? ",
            style = typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = "Create one",
            modifier = Modifier.clickable { onClick() },
            style = typography.bodyMedium,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.surface,
        )
    }
}