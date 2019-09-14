package com.cubesoft.oleksandr.havryliuk.big_hack.data.model

import com.google.gson.annotations.SerializedName

data class Event (
	@SerializedName("space") val space : String,
	@SerializedName("key") val key : String,
	@SerializedName("nonce") val nonce : Int,
	@SerializedName("timestamp") val timestamp : Long,
	@SerializedName("memo") val memo : String,
	@SerializedName("value") val value : String,
	@SerializedName("height") val height : Int,
	@SerializedName("hash") val hash : String,
	@SerializedName("publicKey") val publicKey : String,
	@SerializedName("signature") val signature : String
)