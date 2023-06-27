package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun SetupPinComposable(navController: NavHostController){
    Scaffold(
        topBar = {
            TopBackButtonComposable(text = "Setup Pin", onClick = {
                navController.navigateUp()
            })
        }
    ) {
        it.calculateBottomPadding()

        Box(
            modifier = Modifier
                .padding(15.dp)
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                SinglePasswordField("PIN", "****")
                Spacer(modifier = Modifier.height(10.dp))
                SinglePasswordField("Confirm PIN", "****")
                Spacer(modifier = Modifier.height(30.dp))
                DefaultButton(text = "Procees") {
                    navController.navigateUp()
                }
            }
        }
    }
}