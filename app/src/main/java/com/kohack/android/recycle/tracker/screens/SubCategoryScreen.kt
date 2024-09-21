package com.kohack.android.recycle.tracker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kohack.android.recycle.tracker.R
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SubCategoryScreen(
        categoryInfo : CategoryInfo, subCategoryList : List<SubCategoryInfo>,
        navigateBack : () -> Unit) {

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = categoryInfo.categoryType.name, fontSize = 14.sp) },
            navigationIcon = {
                IconButton(onClick = {
                    navigateBack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "NavigateToHome")
                }
            })

    }) {

        FlowRow(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {
            subCategoryList.forEach {
                SubCategoryItem(it)
            }
        }

    }
}

@Composable
fun SubCategoryItem(categoryInfo : SubCategoryInfo) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
        Icon(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "")
        Text("Paper")
    }
}