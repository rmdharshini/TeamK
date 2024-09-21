package com.kohacks.shared.domain.ecotracker

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kohacks.shared.domain.ecotracker.local.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

object Database {

    fun getDatabaseBuilder(ctx : Context) : AppDatabase {
        val appContext = ctx.applicationContext
        val dbFile = appContext.getDatabasePath("my_room.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext, name = dbFile.absolutePath)
            .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}