package com.kohacks.shared.domain.ecotracker

// Make sure you eventually have this imported properly
// The package prefix should be the same as your database declared above
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kohacks.shared.domain.ecotracker.local.AppDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSUserDomainMask

object Database {

    /*  @OptIn(ExperimentalForeignApi::class)
      fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
          val documentsDirectory = NSFileManager.defaultManager.URLForDirectory(
              directory = NSDocumentDirectory,
              inDomain = NSUserDomainMask,
              appropriateForURL = null,
              create = true,
              error = null,
          )?.path ?: NSHomeDirectory()
          val dbFilePath = "$documentsDirectory/my_room.db"
          return Room.databaseBuilder<AppDatabase>(
              name = dbFilePath,
              factory =  { AppDatabase::class.instantiateImpl() }
          )
      }*/

    fun getDatabaseBuilder() : AppDatabase {
        val dbFilePath = documentDirectory() + "/my_room.db"
        return Room.databaseBuilder<AppDatabase>(name = dbFilePath, factory = {
            AppDatabase::class.
        }).fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .setDriver(BundledSQLiteDriver()).setQueryCoroutineContext(Dispatchers.IO).build()
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory() : String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory?.path)
    }
}

