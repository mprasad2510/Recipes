package org.mp.recipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class LoadTagsResponse (
    @SerializedName("sys") val sys : Sys,
    @SerializedName("fields") val fields : FieldsTags
)

data class FieldsTags (@SerializedName("name") val name : String )