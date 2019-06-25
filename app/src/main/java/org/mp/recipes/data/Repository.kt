package org.mp.recipes.data

import io.reactivex.Single
import org.mp.recipes.data.remote.model.*


interface Repository {

    fun loadList() : Single<Response>
    fun loadDetailList(id:String) : Single<DetailResponse>
    fun loadImage(assetId:String) : Single<LoadImageResponse>
    fun loadTags(entryId:String) : Single<LoadTagsResponse>
}