package com.kohacks.shared.domain.ecotracker.repository.user

import com.kohacks.shared.domain.ecotracker.data.mapper.toUserEntity
import com.kohacks.shared.domain.ecotracker.data.mapper.toUserInfo
import com.kohacks.shared.domain.ecotracker.data.model.UserInfo
import com.kohacks.shared.domain.ecotracker.local.dao.UserDao

class UserRepositoryImpl(private val userDao: UserDao): UserRepository {
    override suspend fun addUser(item: UserInfo) {
        userDao.insert(item.toUserEntity())
    }

    override fun getCurrentUser(): UserInfo {
        return userDao.getCurrentUser().toUserInfo()
    }
}