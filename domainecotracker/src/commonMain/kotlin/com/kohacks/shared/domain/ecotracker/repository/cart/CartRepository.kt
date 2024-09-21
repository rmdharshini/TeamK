package com.kohacks.shared.domain.ecotracker.repository.cart

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.data.model.CartInfo
import com.kohacks.shared.domain.ecotracker.local.entities.CartEntity
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun add(item: CartInfo)

    suspend fun count(): Int

    fun getAllCartAsFlow(): Flow<List<CartInfo>>

    fun getAllCartBySubCategoryId(subCategoryId:Long): Flow<List<CartInfo>>
}