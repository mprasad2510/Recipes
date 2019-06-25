package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.mvibase.MviViewState
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.FieldsUrl
import org.mp.recipes.data.remote.model.ItemsItem


data class UserViewState (val isLoadingUser: Boolean,
                          val errorMessage: String,
                          val isError: Boolean,
                          val userList: Fields?,
                          val showShareOption: Boolean,
                          val user: Fields?
                          ) : MviViewState
{
    companion object {
        fun idle(): UserViewState {
            return UserViewState(
                    isLoadingUser = false,
                    isError = false,
                    errorMessage = "",
                    userList = null,
                    showShareOption = false,
                    user = null
            )
        }
    }
}