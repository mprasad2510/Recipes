package org.mp.recipes.data.di.feature.home.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

data class UserViewModelFactory @Inject constructor(private val userActionProcessorHolder: UserActionProcessorHolder)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(userActionProcessorHolder) as T
    }
}