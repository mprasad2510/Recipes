package org.mp.recipes.data.di.feature.home

import org.mp.recipes.data.di.mvibase.MviResult
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.ItemsItem


sealed class HomeResult : MviResult {
    sealed class LoadHomeResult : HomeResult() {
        data class Success(val newsList: List<ItemsItem>) : LoadHomeResult()
        data class Failure(val errorMessage: Int) : LoadHomeResult()
        object InFlight : LoadHomeResult()
    }

    data class ClickResult(val article: Fields?) : HomeResult()
}