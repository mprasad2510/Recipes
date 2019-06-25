package org.mp.recipes.data.di.feature.home.detail

import org.mp.recipes.data.di.mvibase.MviAction
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.FieldsUrl
import java.lang.reflect.Field


sealed class UserAction : MviAction
{
    object LoadUserAction : UserAction()
    data class ClickAction(val user: Fields?) : UserAction()
}