package org.mp.recipes.data.remote

import io.reactivex.Observable
import io.reactivex.Single
import org.mp.recipes.data.remote.model.*


interface Network {
    fun loadList(): Single<Response>
    fun loadDetail(id:String): Single<DetailResponse>
    fun loadImage(assetId:String) : Single<LoadImageResponse>
    fun loadTags(entryId:String) :  Single<LoadTagsResponse>
}