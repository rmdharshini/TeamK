package com.kohack.android.recycle.tracker.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
        val route : String, val title : String? = null, val icon : ImageVector? = null) {

    object Home : BottomNavigationItems(
        route = "home", title = "Home", icon = Icons.Outlined.Home)

    object Cart : BottomNavigationItems(
        route = "cart", title = "Cart", icon = Icons.Outlined.ShoppingCart)

    object User : BottomNavigationItems(
        route = "user", title = "User", icon = Icons.Outlined.AccountCircle)

    object AddCart : BottomNavigationItems(
        route = "addCart", title = "AddCart", icon = Icons.Outlined.AccountCircle)

    object SubCategory : BottomNavigationItems(
        route = "subCategory", title = "SubCategory", icon = Icons.Outlined.Search)
}