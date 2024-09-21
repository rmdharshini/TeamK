package com.kohack.android.recycle.tracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kohacks.shared.domain.ecotracker.repository.cart.CartRepository
import com.kohacks.shared.domain.ecotracker.repository.category.CategoryRepository
import com.kohacks.shared.domain.ecotracker.repository.subcategory.SubCategoryRepository
import com.kohacks.shared.domain.ecotracker.repository.user.UserRepository

class EcoTrackerViewModelFactory(
        private val cartRepository : CartRepository, private val categoryRepository : CategoryRepository,
        private val subCategoryRepository : SubCategoryRepository,
        private val userRepository : UserRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
        return EcoTrackerViewModel(cartRepository, categoryRepository, subCategoryRepository, userRepository) as T
    }
}