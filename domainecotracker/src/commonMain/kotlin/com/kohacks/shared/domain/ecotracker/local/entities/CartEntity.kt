package com.kohacks.shared.domain.ecotracker.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntity(
        @PrimaryKey(autoGenerate = true)
        val id : Long, val subCategoryId : Long, val categoryType:Int, val subCategoryType : Int, val unit : Int,
        val price : Double, val emission : Double, val scheduleTime : Long, val status : Int)