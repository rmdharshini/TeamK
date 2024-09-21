package com.kohacks.shared.domain.ecotracker.repository.subcategory

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.SubCategoryEntity
import kotlinx.coroutines.flow.Flow

interface SubCategoryRepository {

    suspend fun addSubCategory(item: SubCategoryInfo)

    suspend fun addSubCategoryList(item: List<SubCategoryInfo>)

    fun getAllSubCategoryAsFlow(): Flow<List<SubCategoryInfo>>

    fun getAllSubCategoryById(categoryId:Long): Flow<List<SubCategoryInfo>>
}