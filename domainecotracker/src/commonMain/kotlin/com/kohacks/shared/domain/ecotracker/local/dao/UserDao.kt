package com.kohacks.shared.domain.ecotracker.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.local.entities.CartEntity
import com.kohacks.shared.domain.ecotracker.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: UserEntity)

    @Query("SELECT count(*) FROM UserEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM UserEntity")
    fun getAllAsFlow(): Flow<List<UserEntity>>

    @Query("SELECT * FROM UserEntity LIMIT 1")
    fun getCurrentUser():UserEntity
}