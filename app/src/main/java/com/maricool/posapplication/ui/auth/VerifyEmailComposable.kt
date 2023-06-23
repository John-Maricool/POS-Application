package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maricool.posapplication.ui.theme.typography
import com.maricool.posapplication.utils.Routes

@Composable
fun VerifyEmailComposable(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Hey john, Please verify your email",
                style = typography.bodyMedium,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Enter the 6 digit code sent to your email address",
                style = typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(50.dp))
            PinInputComposable()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Resend in 60 secs",
                style = typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(50.dp))
            DefaultButton(text = "Verify") {
                navController.navigate(Routes.successful_registration)
            }
        }
    }
}

@Composable
fun PinInputComposable() {
    var otpValue by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpValue, onValueChange = {
            if (it.length <= 6) {
                otpValue = it
            }
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(6) { index ->
                    val char = when {
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }
                    Text(
                        char,
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.surface,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp),
                        style = typography.bodySmall,
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}