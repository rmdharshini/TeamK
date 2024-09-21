package com.kohacks.shared.domain.ecotracker.local.entities

import androidx.room.PrimaryKey

data class UserEntity(
        @PrimaryKey(autoGenerate = true)
        val id : Long, val name : String, val emission : Double)