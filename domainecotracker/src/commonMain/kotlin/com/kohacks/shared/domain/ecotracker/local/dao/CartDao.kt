package com.kohacks.shared.domain.ecotracker.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.local.entities.CartEntity
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartEntity)

    @Query("SELECT count(*) FROM CartEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM CartEntity")
    fun getAllCartAsFlow(): Flow<List<CartEntity>>

    @Query("SELECT * FROM CartEntity")
    fun getAllCartBySubCategoryId(subCategoryId:Long): Flow<List<CartEntity>>
}