package org.mp.recipes.data

import io.reactivex.Observable
import org.mp.recipes.data.remote.Network
import org.mp.recipes.data.remote.model.Base
import javax.inject.Inject

 class RepositoryImpl @Inject constructor(private val network: Network) : Repository
{

    override fun loadList(): Observable<Base> {
        return network.loadList()
    }

}