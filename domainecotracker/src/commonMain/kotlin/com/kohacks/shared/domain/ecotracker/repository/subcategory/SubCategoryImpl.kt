package com.kohacks.shared.domain.ecotracker.repository.subcategory

import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo
import kotlinx.coroutines.flow.Flow

class SubCategoryImpl: SubCategoryRepository {
    override suspend fun addSubCategory(item: SubCategoryInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun addSubCategoryList(item: List<SubCategoryInfo>) {
        TODO("Not yet implemented")
    }

    override fun getAllSubCategoryAsFlow(): Flow<List<SubCategoryInfo>> {
        TODO("Not yet implemented")
    }

    override fun getAllSubCategoryById(categoryId: Long): Flow<List<SubCategoryInfo>> {
        TODO("Not yet implemented")
    }
}