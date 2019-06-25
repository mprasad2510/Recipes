package org.mp.recipes.data

import io.reactivex.Single
import org.mp.recipes.data.remote.Network
import org.mp.recipes.data.remote.model.DetailResponse
import org.mp.recipes.data.remote.model.ItemsItem
import org.mp.recipes.data.remote.model.LoadImageResponse
import org.mp.recipes.data.remote.model.Response
import javax.inject.Inject

 class RepositoryImpl @Inject constructor(private val network: Network) : Repository
{
    override fun loadImage(assetId: String): Single<LoadImageResponse> {
        return network.loadImage(assetId)
    }

    override fun loadDetailList(id: String): Single<DetailResponse> {
        return network.loadDetail(id)
    }

    override fun loadList(): Single<Response> {
        return network.loadList()
    }

}