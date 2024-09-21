package com.kohack.android.recycle.tracker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kohack.android.recycle.tracker.ETButton
import com.kohack.android.recycle.tracker.viewmodel.EcoTrackerViewModel
import com.kohack.android.recycle.tracker.R
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController : NavController) {

    val viewModel = viewModel<EcoTrackerViewModel>()
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {

        val query = remember {
            mutableStateOf("Plastic")
        }
        val isActive = remember {
            mutableStateOf(false)
        }

        val categoryList = viewModel.getAllCategoryFlow().collectAsState(initial = listOf())
        SearchBar(query = query.value, onQueryChange = {
            query.value = it
        }, onSearch = {
            query.value = it
        }, active = isActive.value, onActiveChange = {
            isActive.value = it
        }) {

        }

        Card(modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(0.2f)) {

        }

        FlowRow(maxItemsInEachRow = 3) {
            categoryList.value.forEach {
                CategoryItem(it)
            }
        }

        ETButton()

    }
}

@Composable
fun Header() {
    Text(
        "Categories", style = TextStyle(fontSize = 20.sp))
}

@Composable
fun CategoryItem(categoryInfo : CategoryInfo) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
        Icon(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "")
        Text(categoryInfo.categoryType.name, fontSize = 14.sp)
    }
}
