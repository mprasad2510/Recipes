package org.mp.recipes.data.remote

import io.reactivex.Observable
import io.reactivex.Single
import org.mp.recipes.data.remote.model.DetailResponse
import org.mp.recipes.data.remote.model.ItemsItem
import org.mp.recipes.data.remote.model.LoadImageResponse
import org.mp.recipes.data.remote.model.Response


interface Network {
    fun loadList(): Single<Response>
    fun loadDetail(id:String): Single<DetailResponse>
    fun loadImage(assetId:String) : Single<LoadImageResponse>
}