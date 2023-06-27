package com.maricool.posapplication.utils

import com.maricool.posapplication.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.baseline_home_24, Routes.home)
    object Insights: BottomNavItem("Insights",R.drawable.baseline_insights_24,Routes.insights)
    object Settings: BottomNavItem("Settings",R.drawable.baseline_settings,Routes.settings)
}