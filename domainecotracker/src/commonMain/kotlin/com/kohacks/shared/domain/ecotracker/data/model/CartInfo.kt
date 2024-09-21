package com.kohacks.shared.domain.ecotracker.data.model

import com.kohacks.shared.domain.ecotracker.data.enum.CategoryType

data class CartInfo(
        val id : Long, val subCategoryId : Long, val categoryType : CategoryType, val subCategoryType : Int, val unit : Int,
        val price : Double, val emission : Double, val scheduleTime : Long, val status : Int)