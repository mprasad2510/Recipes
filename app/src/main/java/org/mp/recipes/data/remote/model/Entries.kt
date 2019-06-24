package org.mp.recipes.data.remote.model

import com.google.gson.annotations.SerializedName


data class EntriesItem(@SerializedName("sys") val sys: Sys?,
                   @SerializedName("fields") val fields: Fields?)

data class Base(@SerializedName("sys")val sys: Sys?,
                @SerializedName("total") val total: Number?,
                @SerializedName("skip")val skip: Number?,
                @SerializedName("limit") val limit: Number?,
                @SerializedName("items") val items: List<Items>,
                @SerializedName("includes")val includes: Includes?)

data class Chef(@SerializedName("sys")val sys: Sys?)

data class ContentType(@SerializedName("sys")val sys: Sys?)

data class Details(@SerializedName("size")val size: Number?,
                   @SerializedName("image")val image: Image?)

data class Environment(@SerializedName("sys")val sys: Sys?)

data class Fields(@SerializedName("title")val title: String?,
                  @SerializedName("photo")val photo: Photo?,
                  @SerializedName("calories")val calories: Number?,
                  @SerializedName("description")val description: String?,
                  @SerializedName("chef")val chef: Chef?,
                  @SerializedName("tags")val tags: List<Tags60296585>?)

data class File(@SerializedName("url")val url: String?,
                @SerializedName("details")val details: Details?,
                @SerializedName("filename")val fileName: String?,
                @SerializedName("contentType")val contentType: String?)

data class Image(@SerializedName("width")val width: Number?,
                 @SerializedName("height") val height: Number?)

data class Includes(@SerializedName("Asset")val Asset: List<EntriesItem>?)

data class Items(@SerializedName("sys")val sys: Sys,
                 @SerializedName("fields")val fields: Fields)

data class Photo(@SerializedName("sys")val sys: Sys?)

data class Space(@SerializedName("sys")val sys: Sys?)

data class Sys(@SerializedName("space")val space: Space?,
               @SerializedName("id")val id: String?,
               @SerializedName("type")val type: String?,
               @SerializedName("createdAt")val createdAt: String?,
               @SerializedName("updatedAt")val updatedAt: String?,
               @SerializedName("environment") val environment: Environment?,
               @SerializedName("revision")val revision: Number?,
               @SerializedName("contentType")val contentType: ContentType?,
               @SerializedName("locale")val locale: String?)

data class Tags(@SerializedName("sys")val sys: Sys?)

data class Tags60296585(@SerializedName("sys")val sys: Sys?)