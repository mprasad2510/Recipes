package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.mvibase.MviResult
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.FieldsUrl
import org.mp.recipes.data.remote.model.ItemsItem


sealed class UserResult : MviResult {
    sealed class LoadUserResult : UserResult() {
        data class Success(val userList: Fields) : LoadUserResult()
        data class Failure(val errorMessage: String) : LoadUserResult()
        object InFlight : LoadUserResult()
    }

    data class ClickResult(val user: Fields?) : UserResult()
}