package com.kohacks.shared.domain.ecotracker.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(item: CategoryEntity)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertBulk(item: List<CategoryEntity>)

  @Query("SELECT count(*) FROM CategoryEntity")
  suspend fun count(): Int

  @Query("SELECT * FROM CategoryEntity")
  fun getAllCategoryAsFlow(): Flow<List<CategoryEntity>>
}