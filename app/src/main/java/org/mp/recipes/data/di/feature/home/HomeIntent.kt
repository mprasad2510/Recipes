package org.mp.recipes.data.di.feature.home

import org.mp.recipes.data.di.mvibase.MviIntent
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.Items


sealed class HomeIntent : MviIntent {
    object InitialIntent : HomeIntent()
    data class ClickIntent(val article: Fields?):HomeIntent()
}