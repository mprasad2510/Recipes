package org.mp.recipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class Response(

	@SerializedName("total")
	val total: Int,

	@SerializedName("limit")
	val limit: Int,

	@SerializedName("skip")
	val skip: Int,

	@SerializedName("includes")
	val includes: Includes,

	@SerializedName("sys")
	val sys: Sys,

	@SerializedName("items")
	val items: List<ItemsItem>
)

data class Space(

	@SerializedName("sys")
	val sys: Sys
)

data class Sys(

	@SerializedName("linkType")
	val linkType: String,

	@SerializedName("id")
	val id: String,

	@SerializedName("type")
	val type: String,

	@SerializedName("createdAt")
	val createdAt: String,

	@SerializedName("environment")
	val environment: Environment,

	@SerializedName("locale")
	val locale: String,

	@SerializedName("contentType")
	val contentType: ContentType,

	@SerializedName("space")
	val space: Space,

	@SerializedName("updatedAt")
	val updatedAt: String,

	@SerializedName("revision")
	val revision: Int
)
data class TagsItem(

	@SerializedName("sys")
	val sys: Sys
)
data class Photo(

	@SerializedName("sys")
	val sys: Sys
)
data class ItemsItem(

	@SerializedName("sys")
	val sys: Sys,

	@SerializedName("fields")
	val fields: Fields
)

data class Includes(

	@SerializedName("Asset")
	val asset: List<AssetItem>
)
data class Image(

	@SerializedName("width")
	val width: Int,

	@SerializedName("height")
	val height: Int
)
data class File(

	@SerializedName("fileName")
	val fileName: String,

	@SerializedName("details")
	val details: Details,

	@SerializedName("contentType")
	val contentType: String,

	@SerializedName("url")
	val url: String
)
data class Fields(

	@SerializedName("photo")
	val photo: Photo,

	@SerializedName("description")
	val description: String,

	@SerializedName("calories")
	val calories: Int,

	@SerializedName("title")
	val title: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("chef")
	val chef: Chef,

	@SerializedName("tags")
	val tags: List<TagsItem>,

	@SerializedName("country")
	val country: String,

	@SerializedName("css")
	val css: String,

	@SerializedName("body")
	val body: String,

	@SerializedName("brand")
	val brand: String,

	@SerializedName("slug")
	val slug: String,

	@SerializedName("javascript")
	val javascript: String
)

data class Environment(

	@SerializedName("sys")
	val sys: Sys
)
data class Details(

	@field:SerializedName("image")
	val image: Image,

	@SerializedName("size")
	val size: Int
)

data class ContentType(

	@SerializedName("sys")
	val sys: Sys
)
data class Chef(

	@SerializedName("sys")
	val sys: Sys
)
data class AssetItem(

	@SerializedName("sys")
	val sys: Sys,

	@SerializedName("fields")
	val fields: Fields
)