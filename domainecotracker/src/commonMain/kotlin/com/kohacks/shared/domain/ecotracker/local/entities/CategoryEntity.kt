package com.kohacks.shared.domain.ecotracker.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
        @PrimaryKey(autoGenerate = true)
        val id : Long = 0, val type : Int)