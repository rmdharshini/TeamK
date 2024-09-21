package com.kohack.android.recycle.tracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Card
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
import com.kohacks.shared.domain.ecotracker.data.model.CartInfo
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(cartInfoList:List<CartInfo>){


        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Cart", fontSize = 14.sp) },
                navigationIcon = {
                })

        }) {

            LazyColumn(modifier = Modifier.padding(it)) {
                items(cartInfoList){ cartInfo ->
                    CartItemCard(cartInfo)
                }
            }

        }
}

@Composable
fun CartItemCard(cartInfo : CartInfo){
    Card(modifier = Modifier.padding(16.dp)) {
        Row {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "")

            Column {
                Text(text = cartInfo.subCategoryType.toString(), fontSize = 16.sp)
                Text(text = cartInfo.categoryType.name, fontSize = 14.sp)
            }
        }
    }
}