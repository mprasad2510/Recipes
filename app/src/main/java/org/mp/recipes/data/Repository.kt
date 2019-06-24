package org.mp.recipes.data

import io.reactivex.Observable
import org.mp.recipes.data.remote.model.Base


interface Repository {

    fun loadList() : Observable<Base>

}