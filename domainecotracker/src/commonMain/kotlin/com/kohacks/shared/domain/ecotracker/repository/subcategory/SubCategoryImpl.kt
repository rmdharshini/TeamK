package com.kohacks.shared.domain.ecotracker.repository.subcategory

import com.kohacks.shared.domain.ecotracker.data.mapper.toSubCategoryEntity
import com.kohacks.shared.domain.ecotracker.data.mapper.toSubCategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo
import com.kohacks.shared.domain.ecotracker.local.dao.SubCategoryDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubCategoryImpl(private val subCategoryDao: SubCategoryDao): SubCategoryRepository {
    override suspend fun addSubCategory(item: SubCategoryInfo) {
        subCategoryDao.insert(item.toSubCategoryEntity())
    }

    override suspend fun addSubCategoryList(item: List<SubCategoryInfo>) {
        item.forEach {
            subCategoryDao.insert(it.toSubCategoryEntity())
        }
    }

    override fun getAllSubCategoryAsFlow(): Flow<List<SubCategoryInfo>> {
        return subCategoryDao.getAllSubCategoryAsFlow().map { it.map { it.toSubCategoryInfo() } }
    }

    override fun getAllSubCategoryById(categoryId: Long): Flow<List<SubCategoryInfo>> {
        return subCategoryDao.getAllSubCategoryById(categoryId).map { it.map { it.toSubCategoryInfo() } }
    }
}