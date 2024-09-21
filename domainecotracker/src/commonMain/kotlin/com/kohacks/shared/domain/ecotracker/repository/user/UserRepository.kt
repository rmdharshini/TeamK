package com.kohacks.shared.domain.ecotracker.repository.user

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kohacks.shared.domain.ecotracker.data.model.UserInfo
import com.kohacks.shared.domain.ecotracker.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun addUser(item: UserInfo)

    fun getCurrentUser(): UserInfo
}