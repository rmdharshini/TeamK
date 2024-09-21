package com.kohacks.shared.domain.ecotracker.data.mapper

import com.kohacks.shared.domain.ecotracker.data.enum.CategoryType
import com.kohacks.shared.domain.ecotracker.data.model.CartInfo
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.SubCategoryInfo
import com.kohacks.shared.domain.ecotracker.data.model.UserInfo
import com.kohacks.shared.domain.ecotracker.local.entities.CartEntity
import com.kohacks.shared.domain.ecotracker.local.entities.CategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.SubCategoryEntity
import com.kohacks.shared.domain.ecotracker.local.entities.UserEntity

fun CategoryEntity.toCategoryInfo() : CategoryInfo {
    return CategoryInfo(id, type.toCategoryType())
}

fun UserEntity.toUserInfo() : UserInfo {
    return UserInfo(id, name, emission)
}

fun SubCategoryEntity.toSubCategoryInfo() : SubCategoryInfo {
    return SubCategoryInfo(subCategoryId = id, categoryId, type, price, emission)
}

fun CartEntity.toCartInfo() : CartInfo {
    return CartInfo(id, subCategoryId, categoryType.toCategoryType(), subCategoryType,  unit, price, emission, scheduleTime, status)
}

fun Int.toCategoryType() : CategoryType {
    return when(this) {
        CategoryType.PAPER.value -> CategoryType.PAPER
        CategoryType.CLOTHES.value -> CategoryType.CLOTHES
        CategoryType.ELECTRONICS.value -> CategoryType.ELECTRONICS
        else -> CategoryType.OTHER
    }
}


fun CartInfo.toCartEntity() : CartEntity {
    return CartEntity(id, subCategoryId, categoryType.value, subCategoryType, unit, price, emission, scheduleTime, status)
}