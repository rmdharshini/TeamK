package com.kohacks.shared.domain.ecotracker.repository.user

import com.kohacks.shared.domain.ecotracker.data.model.UserInfo

class UserRepositoryImpl: UserRepository {
    override suspend fun addUser(item: UserInfo) {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): UserInfo {
        TODO("Not yet implemented")
    }
}