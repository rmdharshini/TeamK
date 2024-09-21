package com.kohack.android.recycle.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kohack.android.recycle.tracker.component.BottomBar
import com.kohack.android.recycle.tracker.navigation.NavigationGraph
import com.kohack.android.recycle.tracker.viewmodel.EcoTrackerViewModel

class MainActivity : ComponentActivity() {

    private val instance by lazy {
        Instance(this)
    }



    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController : NavHostController = rememberNavController()
            val buttonsVisible = remember { mutableStateOf(true) }

            val viewModel = viewModel<EcoTrackerViewModel>(factory = instance.viewModelFactory)
            viewModel.addCategoryList()
            Scaffold(bottomBar = {
                if(buttonsVisible.value) {
                    BottomBar(
                        navController = navController, state = buttonsVisible.value, modifier = Modifier)
                }
            }) { paddingValues ->
                Box(
                    modifier = Modifier.padding(paddingValues)) {
                    NavigationGraph(navController = navController, viewModel) { isVisible ->
                        buttonsVisible.value = isVisible
                    }
                }
            }
        }
    }
}

@Composable
fun ETButton() {
    TextButton(onClick = {

    }, modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .background(Color.Black)) {
        Text("Add to cart", color = Color.White, fontSize = 14.sp)
    }
}