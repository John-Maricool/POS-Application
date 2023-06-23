package com.maricool.posapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maricool.posapplication.ui.auth.ForgotPasswordComposable
import com.maricool.posapplication.ui.auth.SignInComposable
import com.maricool.posapplication.ui.auth.SignUpComposable
import com.maricool.posapplication.ui.auth.SuccessfulRegistrationComposable
import com.maricool.posapplication.ui.auth.VerifyEmailComposable
import com.maricool.posapplication.ui.theme.POSApplicationTheme
import com.maricool.posapplication.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSApplicationTheme {
                MyAppNavHost()
            }
        }
    }
}

@Composable
fun MyAppNavHost(
) {
val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.sign_in, builder = {
        composable(Routes.sign_in){
            SignInComposable(navController)
        }
        composable(Routes.sign_up){
            SignUpComposable(navController)
        }
        composable(Routes.verify_email){
            VerifyEmailComposable(navController = navController)
        }
        composable(Routes.successful_registration){
            SuccessfulRegistrationComposable(navController = navController)
        }
        composable(Routes.forgot_password){
            ForgotPasswordComposable(navController)
        }
    })
}
