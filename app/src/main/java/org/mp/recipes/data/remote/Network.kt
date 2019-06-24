package org.mp.recipes.data.remote

import io.reactivex.Observable
import org.mp.recipes.data.remote.model.Base


interface Network {
    fun loadList(): Observable<Base>
}