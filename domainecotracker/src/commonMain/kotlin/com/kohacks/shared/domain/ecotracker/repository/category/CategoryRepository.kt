package com.kohacks.shared.domain.ecotracker.repository.category

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun addCategory(item: CategoryInfo)

    suspend fun addCategoryList(item: List<CategoryInfo>)

    fun getAllCategoryAsFlow(): Flow<List<CategoryInfo>>
}