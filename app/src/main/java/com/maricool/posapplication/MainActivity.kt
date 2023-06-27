package com.maricool.posapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.maricool.posapplication.ui.BottomNav
import com.maricool.posapplication.ui.MyAppNavHost
import com.maricool.posapplication.ui.theme.POSApplicationTheme
import com.maricool.posapplication.utils.BottomNavItem
import com.maricool.posapplication.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bottomNavScreens = listOf(
                BottomNavItem.Home.screen_route,
                BottomNavItem.Settings.screen_route,
                BottomNavItem.Insights.screen_route
            )

            POSApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        Log.d("ddd", navController.currentBackStackEntry?.destination?.route.toString())
                        if (navController.currentBackStackEntry?.destination?.route == Routes.home) {
                            BottomNav(navController = navController)
                        }
                    },
                    content = { padd ->
                        padd.calculateTopPadding()
                        Log.d("ddd", navController.currentBackStackEntry?.destination?.route.toString())
                        MyAppNavHost(navController = navController)
                    }
                )
            }
        }
    }
}


