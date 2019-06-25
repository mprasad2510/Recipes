package org.mp.recipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class DetailResponse (
    @SerializedName("sys") val sys : Sys,
    @SerializedName("fields") val fields : Fields
)
