package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.feature.home.detail.UserActivity.Companion.assetId
import org.mp.recipes.data.di.mvibase.MviViewState
import org.mp.recipes.data.remote.model.*

data class UserViewState (val isLoadingUser: Boolean,
                          val errorMessage: String,
                          val isError: Boolean,
                          val userList: Fields?,
                          val imageList : FieldsUrl?,
                          val tagsList : FieldsTags?,
                          val assetId : Photo?,
                          val entryId : TagsItem?,
                          val showShareOption: Boolean,
                          val user: Fields?
                          ) : MviViewState
{
    companion object {
        fun idle(): UserViewState {
            return UserViewState(
                    isLoadingUser = false,
                    isError = false,
                    imageList = null,
                    tagsList = null,
                    errorMessage = "",
                    userList = null,
                    showShareOption = false,
                    user = null,
                    assetId = null,
                    entryId = null
            )
        }
    }
}