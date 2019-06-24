package org.mp.recipes.data.remote


import io.reactivex.Observable
import org.mp.recipes.data.remote.model.Base
import org.mp.recipes.data.remote.retrofit.NetworkApi


class NetworkImpl(private val networkApi: NetworkApi) : Network {

    override fun loadList() : Observable<Base>
        {
            return networkApi.loadList()

        }
}