package org.mp.recipes.data

import io.reactivex.Single
import org.mp.recipes.data.remote.model.DetailResponse
import org.mp.recipes.data.remote.model.ItemsItem
import org.mp.recipes.data.remote.model.LoadImageResponse
import org.mp.recipes.data.remote.model.Response


interface Repository {

    fun loadList() : Single<Response>
    fun loadDetailList(id:String) : Single<DetailResponse>
    fun loadImage(assetId:String) : Single<LoadImageResponse>
}