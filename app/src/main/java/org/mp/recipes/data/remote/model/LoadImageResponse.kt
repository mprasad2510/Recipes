package org.mp.recipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class LoadImageResponse (
    @SerializedName("sys") val sys : Sys,
    @SerializedName("fields") val fields : FieldsUrl

)

data class FieldsUrl(
    @SerializedName("title") val title : String,
    @SerializedName("file") val file : FileUrl

)

data class FileUrl
    (
    @SerializedName("url") val url : String,
    @SerializedName("details") val detail : DetailUrl

)
data class DetailUrl
    (
    @SerializedName("filename") val filename : String,
    @SerializedName("contentType") val contentType:String

)