package org.mp.recipes.data.di.feature.home

import org.mp.recipes.data.di.mvibase.MviViewState
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.ItemsItem


data class HomeViewState(val isLoading: Boolean,
                         val errorMessage: Int,
                         val isError: Boolean,
                         val articles: List<ItemsItem>,
                         val showShareOption: Boolean,
                         val shareArticle: Fields?
) : MviViewState {

    companion object {
        fun idle(): HomeViewState {
            return HomeViewState(
                    isLoading = false,
                    isError = false,
                    errorMessage = 0,
                    articles = emptyList(),
                    showShareOption = false,
                    shareArticle = null

            )
        }
    }
}