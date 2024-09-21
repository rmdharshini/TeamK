package com.kohacks.shared.domain.ecotracker.repository.impl

import com.kohacks.shared.domain.ecotracker.data.mapper.toCartEntity
import com.kohacks.shared.domain.ecotracker.data.mapper.toCartInfo
import com.kohacks.shared.domain.ecotracker.data.model.CartInfo
import com.kohacks.shared.domain.ecotracker.local.dao.CartDao
import com.kohacks.shared.domain.ecotracker.repository.cart.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartImpl(private val cartDao: CartDao): CartRepository {
    override suspend fun add(item: CartInfo) {
        cartDao.insert(item.toCartEntity())
    }

    override suspend fun count(): Int {
       return cartDao.count()
    }

    override fun getAllCartAsFlow(): Flow<List<CartInfo>> {
        return cartDao.getAllCartAsFlow().map { it.map { it.toCartInfo() } }
    }

    override fun getAllCartBySubCategoryId(subCategoryId: Long): Flow<List<CartInfo>> {
        return cartDao.getAllCartBySubCategoryId(subCategoryId).map { it.map { it.toCartInfo() } }
    }

}