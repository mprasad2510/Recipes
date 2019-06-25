package org.mp.recipes.data.remote


import io.reactivex.Observable
import io.reactivex.Single
import org.mp.recipes.data.remote.model.DetailResponse
import org.mp.recipes.data.remote.model.ItemsItem
import org.mp.recipes.data.remote.model.LoadImageResponse
import org.mp.recipes.data.remote.model.Response
import org.mp.recipes.data.remote.retrofit.NetworkApi


class NetworkImpl(private val networkApi: NetworkApi) : Network {
    override fun loadImage(assetId: String): Single<LoadImageResponse> {
        return networkApi.loadImage("kk2bw5ojx476","master",assetId,"7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")
    }

    override fun loadDetail(id:String): Single<DetailResponse> {
        return networkApi.loadDetailList("kk2bw5ojx476","master",id,"7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")

    }

    override fun loadList() : Single<Response>
        {
            return networkApi.loadList("kk2bw5ojx476","master","7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")

        }
}