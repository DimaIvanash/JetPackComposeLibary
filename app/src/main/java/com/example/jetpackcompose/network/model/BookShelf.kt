package com.example.example.bookshelf
import com.google.gson.annotations.SerializedName

data class BookShelf (
  @SerializedName("kind")
  var kind: String? = null,
  @SerializedName("totalItems" ) var totalItems : Int?             = null,
  @SerializedName("items"      ) var items      : ArrayList<Items> = arrayListOf()

)



