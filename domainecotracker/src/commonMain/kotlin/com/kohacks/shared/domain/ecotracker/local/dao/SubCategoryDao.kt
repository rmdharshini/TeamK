package com.kohacks.shared.domain.ecotracker.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.SubCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: SubCategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBulk(item: List<CategoryEntity>)

    @Query("SELECT count(*) FROM SubCategoryEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM SubCategoryEntity")
    fun getAllSubCategoryAsFlow(): Flow<List<SubCategoryEntity>>

    @Query("SELECT * FROM SubCategoryEntity")
    fun getAllSubCategoryById(categoryId:Long): Flow<List<SubCategoryEntity>>
}