package org.mp.recipes.data

import io.reactivex.Single
import org.mp.recipes.data.remote.Network
import org.mp.recipes.data.remote.model.*
import javax.inject.Inject

 class RepositoryImpl @Inject constructor(private val network: Network) : Repository
{
    override fun loadTags(entryId: String): Single<LoadTagsResponse> {
        return network.loadTags(entryId)
    }

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