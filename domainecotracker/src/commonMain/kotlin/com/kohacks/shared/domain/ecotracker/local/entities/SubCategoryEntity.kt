package com.kohacks.shared.domain.ecotracker.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubCategoryEntity(
        @PrimaryKey(autoGenerate = true)
        val id : Long = 0,
        val categoryId:Long,
        val type : Int, val price : Double,
        val emission : Double)