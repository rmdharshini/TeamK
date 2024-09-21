package com.kohack.android.recycle.tracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kohacks.shared.domain.ecotracker.data.enum.CategoryType
import com.kohacks.shared.domain.ecotracker.data.model.CategoryInfo
import com.kohacks.shared.domain.ecotracker.repository.cart.CartRepository
import com.kohacks.shared.domain.ecotracker.repository.category.CategoryRepository
import com.kohacks.shared.domain.ecotracker.repository.subcategory.SubCategoryRepository
import com.kohacks.shared.domain.ecotracker.repository.user.UserRepository
import kotlinx.coroutines.launch

class EcoTrackerViewModel(
        val cartRepository : CartRepository, private val categoryRepository : CategoryRepository,
        private val subCategoryRepository : SubCategoryRepository,
        val userRepository : UserRepository) : ViewModel() {



    fun getAllCategoryFlow() =
        categoryRepository.getAllCategoryAsFlow()

    fun getAllSubCategoryFlowById(categoryId:Long){
        subCategoryRepository.getAllSubCategoryById(categoryId)
    }

    fun addCategoryList(){
        viewModelScope.launch {
            val list = listOf<CategoryInfo>(
                CategoryInfo(1L, CategoryType.PLASTIC), CategoryInfo(1L, CategoryType.ELECTRONICS),
                CategoryInfo(1L, CategoryType.PAPER), CategoryInfo(1L, CategoryType.CLOTHES),
                CategoryInfo(1L, CategoryType.OTHER))

            categoryRepository.addCategoryList(list)
        }
    }

}