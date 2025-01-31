package com.example.example.bookshelf

import com.google.gson.annotations.SerializedName


data class ListPrice (

  @SerializedName("amountInMicros" ) var amountInMicros : Float? = null,
  @SerializedName("currencyCode"   ) var currencyCode   : String? = null

)