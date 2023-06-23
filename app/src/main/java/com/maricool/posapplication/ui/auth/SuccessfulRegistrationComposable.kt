package com.maricool.posapplication.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maricool.posapplication.R
import com.maricool.posapplication.ui.theme.typography
import com.maricool.posapplication.utils.Routes

@Composable
fun SuccessfulRegistrationComposable(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
            .paint(
            painterResource(id = R.drawable.img), contentScale = ContentScale.FillBounds)){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = "Successful",
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Hooraay",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "Registration Successful",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "You can now log in into your POS account",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Box(modifier = Modifier.padding(20.dp).fillMaxSize(),
            contentAlignment = Alignment.BottomCenter) {
            DefaultButtonWhite(text = "Proceed to Login") {
                navController.popBackStack(Routes.sign_in, false)
            }
        }
    }
}