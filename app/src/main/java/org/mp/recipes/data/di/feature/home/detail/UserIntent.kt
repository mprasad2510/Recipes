package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.mvibase.MviIntent
import org.mp.recipes.data.remote.model.Chef
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.Photo
import org.mp.recipes.data.remote.model.TagsItem


sealed class UserIntent : MviIntent {
    object InitialIntent : UserIntent()
    object LoadImageIntent : UserIntent()
    object LoadTagsIntent : UserIntent()
    data class ClickIntent(val user: Fields?): UserIntent()
}