package com.kohacks.shared.domain.ecotracker.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kohacks.shared.domain.ecotracker.local.dao.CartDao
import com.kohacks.shared.domain.ecotracker.local.dao.CategoryDao
import com.kohacks.shared.domain.ecotracker.local.dao.SubCategoryDao
import com.kohacks.shared.domain.ecotracker.local.dao.UserDao
import com.kohacks.shared.domain.ecotracker.local.entities.CartEntity
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.SubCategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [CategoryEntity::class, SubCategoryEntity::class, CartEntity::class, UserEntity::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartDao() : CartDao

    abstract fun categoryDao() : CategoryDao

    abstract fun subCategoryDao() : SubCategoryDao

    abstract fun userDao() : UserDao

}



