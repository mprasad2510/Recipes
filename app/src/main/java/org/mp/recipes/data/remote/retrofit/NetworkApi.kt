package org.mp.recipes.data.remote.retrofit

import io.reactivex.Observable
import org.mp.recipes.data.remote.model.Base
import retrofit2.http.*


interface NetworkApi {
    companion object {
        const val BASE_URL = "https://cdn.contentful.com"

    }


    @GET("/spaces/kk2bw5ojx476/environments/master/entries?access_token=7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")
    fun loadList(): Observable<Base>

//
//    @GET("/spaces/kk2bw5ojx476/environments/master/entries/61Lgvo6rzUIgIGgcOAMgQ8?access_token=7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")
//    fun loadlistDetail(@Path("doctorId") contentId:Doctors) : Observable<String>
}

