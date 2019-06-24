package org.mp.recipes.data.di.feature.home

import org.mp.recipes.data.di.mvibase.MviAction
import org.mp.recipes.data.remote.model.Fields


sealed class HomeAction : MviAction {
    object LoadHomeAction : HomeAction()
    data class ClickAction(val article: Fields?) : HomeAction()
}