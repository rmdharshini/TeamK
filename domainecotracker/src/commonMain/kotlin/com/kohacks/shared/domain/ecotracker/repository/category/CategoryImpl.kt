package com.kohacks.shared.domain.ecotracker.repository.category

import com.kohacks.shared.domain.ecotracker.data.mapper.toCategoryEntity
import com.kohacks.shared.domain.ecotracker.data.mapper.toCategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.local.dao.CategoryDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryImpl(private val categoryDao: CategoryDao): CategoryRepository {
    override suspend fun addCategory(item: CategoryInfo) {
        categoryDao.insert(item.toCategoryEntity())
    }

    override suspend fun addCategoryList(item: List<CategoryInfo>) {
        item.forEach {
            categoryDao.insert(it.toCategoryEntity())
        }
    }

    override fun getAllCategoryAsFlow(): Flow<List<CategoryInfo>> {
        return categoryDao.getAllCategoryAsFlow().map { it.map { it.toCategoryInfo() } }
    }
}