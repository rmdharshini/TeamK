package com.kohacks.shared.domain.ecotracker.data.model

data class CartInfo(
        val id : Long, val subCategoryId : Long, val subCategoryType : Int, val unit : Int,
        val price : Double, val emission : Double, val scheduleTime : Long, val status : Int)