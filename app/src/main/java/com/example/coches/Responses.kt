package com.example.coches
import com.google.gson.annotations.SerializedName

data class userRes(var id: Number, var user: String, var password:String);
data class getUserRes(@SerializedName("status") var status:String)

data class evaluationType(var id: Number, var folio:String, var version: Number, var idVehiculo: Number);
data class searchFolioRes(@SerializedName("status") var status:String, @SerializedName("evaluation") var evaluation:evaluationType);
