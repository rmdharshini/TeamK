package com.kohack.android.recycle.tracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kohack.android.recycle.tracker.component.BottomNavigationItems
import com.kohack.android.recycle.tracker.screens.AddToCartScreen
import com.kohack.android.recycle.tracker.screens.CartScreen
import com.kohack.android.recycle.tracker.screens.HomeScreen
import com.kohack.android.recycle.tracker.screens.SubCategoryScreen
import com.kohack.android.recycle.tracker.screens.UserScreen
import com.kohack.android.recycle.tracker.viewmodel.EcoTrackerViewModel
import com.kohacks.shared.domain.ecotracker.data.enum.CategoryType
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo

@Composable
fun NavigationGraph(
        navController : NavHostController, viewModel : EcoTrackerViewModel,
        onBottomBarVisibilityChanged : (Boolean) -> Unit) {
    NavHost(navController, startDestination = BottomNavigationItems.Home.route) {
        composable(BottomNavigationItems.Home.route) {
            onBottomBarVisibilityChanged(true)
            HomeScreen(navController = navController)
        }
        composable(BottomNavigationItems.Cart.route) {
            onBottomBarVisibilityChanged(true)
            val cartListState = viewModel.cartRepository.getAllCartAsFlow().collectAsState(
                initial = listOf())
            CartScreen(cartListState.value)
        }
        composable(BottomNavigationItems.AddCart.route) {
            onBottomBarVisibilityChanged(true)
            AddToCartScreen()
        }

        composable(BottomNavigationItems.User.route) {
            onBottomBarVisibilityChanged(true)
            UserScreen()
        }

        composable(BottomNavigationItems.SubCategory.route) {
            onBottomBarVisibilityChanged(true)
            SubCategoryScreen(CategoryInfo(1L, CategoryType.PAPER), listOf<SubCategoryInfo>()){
                navController.navigateUp()
            }
        }
    }
}