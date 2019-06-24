package org.mp.recipes.data.di.feature.home

import org.mp.recipes.data.di.mvibase.MviViewState
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.Items


data class HomeViewState(val isLoading: Boolean,
                         val errorMessage: String,
                         val isError: Boolean,
                         val articles: List<Items>,
                         val showShareOption: Boolean,
                         val shareArticle: Fields?
) : MviViewState {

    companion object {
        fun idle(): HomeViewState {
            return HomeViewState(
                    isLoading = false,
                    isError = false,
                    errorMessage = "",
                    articles = emptyList(),
                    showShareOption = false,
                    shareArticle = null

            )
        }
    }
}