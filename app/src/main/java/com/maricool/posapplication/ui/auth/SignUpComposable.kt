package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavHostController
import com.maricool.posapplication.ui.theme.typography
import com.maricool.posapplication.utils.Routes

@Composable
fun SignUpComposable(navController: NavHostController){
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Column(modifier = Modifier.align(Alignment.TopStart)) {
            Text(
                "Let's have your details",
                style = typography.bodyMedium,
                color = MaterialTheme.colorScheme.surface
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Glad to have you join Oralce",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(30.dp))
            SingleInputField("What's your business name", "eg Oracle Enterprise")
            Spacer(modifier = Modifier.height(15.dp))
            SingleInputField("Business phone", "eg  09018247823")
            Spacer(modifier = Modifier.height(15.dp))
            SingleInputField("Business Email", "eg oracle@gmail.com")
            Spacer(modifier = Modifier.height(15.dp))
            SinglePasswordField("Enter your password", "****")
            Spacer(modifier = Modifier.height(15.dp))
            SinglePasswordField("Confirm your password", "****")

            Spacer(modifier = Modifier.height(30.dp))
            DefaultButton(text = "Proceed") {
                    navController.navigate(Routes.verify_email)
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}