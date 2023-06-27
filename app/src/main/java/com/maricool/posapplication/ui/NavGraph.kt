package com.maricool.posapplication.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maricool.posapplication.ui.auth.ForgotPasswordComposable
import com.maricool.posapplication.ui.auth.SetupPinComposable
import com.maricool.posapplication.ui.auth.SignInComposable
import com.maricool.posapplication.ui.auth.SignUpComposable
import com.maricool.posapplication.ui.auth.SuccessfulRegistrationComposable
import com.maricool.posapplication.ui.auth.VerifyEmailComposable
import com.maricool.posapplication.utils.Routes

@Composable
fun MyAppNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Routes.home, builder = {
        composable(Routes.sign_in) {
            SignInComposable(navController)
        }
        composable(Routes.sign_up) {
            SignUpComposable(navController)
        }
        composable(Routes.verify_email) {
            VerifyEmailComposable(navController = navController)
        }
        composable(Routes.successful_registration) {
            SuccessfulRegistrationComposable(navController = navController)
        }
        composable(Routes.forgot_password) {
            ForgotPasswordComposable(navController)
        }
        composable(Routes.home) {
            HomeComposable(navController = navController)
        }
        composable(Routes.insights) {
            InsightsComposable(navController = navController)
        }
        composable(Routes.settings) {
            SettingsComposable(navController = navController)
        }
        composable(Routes.setup_pin){
            SetupPinComposable(navController = navController)
        }
    })
}