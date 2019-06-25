package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.mvibase.MviIntent
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.FieldsUrl


sealed class UserIntent : MviIntent {
    object InitialIntent : UserIntent()
    data class ClickIntent(val user: Fields?): UserIntent()
}