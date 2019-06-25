package org.mp.recipes.data.remote.retrofit

import io.reactivex.Single
import org.mp.recipes.data.remote.model.DetailResponse
import org.mp.recipes.data.remote.model.LoadImageResponse
import org.mp.recipes.data.remote.model.Response
import retrofit2.http.*


interface NetworkApi {
    companion object {
        const val BASE_URL = "https://cdn.contentful.com"
    }
    @GET("/spaces/{space_id}/environments/{environment_id}/entries")
    fun loadList(@Path("space_id")  spaceId:String, @Path("environment_id") environmentId : String, @Query("access_token") accessToken: String): Single<Response>

    @GET("/spaces/{space_id}/environments/{environment_id}/entries/{entry_id}")
    fun loadDetailList(@Path("space_id")  spaceId:String, @Path("environment_id")
    environmentId : String, @Path("entry_id") id : String, @Query("access_token")accessToken: String): Single<DetailResponse>

    @GET("/spaces/{space_id}/environments/{environment_id}/assets/{asset_id}")
    fun loadImage(@Path("space_id") spaceId: String,@Path("environment_id") environmentId: String,
                  @Path("asset_id") assetId: String, @Query("access_token") accessToken: String) : Single<LoadImageResponse>
}

