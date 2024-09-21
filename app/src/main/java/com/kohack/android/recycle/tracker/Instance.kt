package com.kohack.android.recycle.tracker

import android.content.Context
import com.kohack.android.recycle.tracker.viewmodel.EcoTrackerViewModelFactory
import com.kohacks.shared.domain.ecotracker.Database
import com.kohacks.shared.domain.ecotracker.local.getRoomDatabase
import com.kohacks.shared.domain.ecotracker.repository.cart.CartImpl
import com.kohacks.shared.domain.ecotracker.repository.cart.CartRepository
import com.kohacks.shared.domain.ecotracker.repository.category.CategoryImpl
import com.kohacks.shared.domain.ecotracker.repository.category.CategoryRepository
import com.kohacks.shared.domain.ecotracker.repository.subcategory.SubCategoryImpl
import com.kohacks.shared.domain.ecotracker.repository.user.UserRepository
import com.kohacks.shared.domain.ecotracker.repository.user.UserRepositoryImpl

class Instance(val context: Context) {

    val database by lazy {
        getRoomDatabase(Database.getDatabaseBuilder(context))
    }

    val cartRepository by lazy<CartRepository> {
        CartImpl(database.cartDao())
    }

    val categoryRepository by lazy<CategoryRepository> {
        CategoryImpl(database.categoryDao())
    }

    val subCategoryRepository by lazy {
        SubCategoryImpl(database.subCategoryDao())
    }

    val userRepository by lazy {
        UserRepositoryImpl(database.userDao())
    }

    val viewModelFactory by lazy {
        EcoTrackerViewModelFactory(cartRepository, categoryRepository, subCategoryRepository, userRepository)
    }
}