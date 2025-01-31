package com.example.jetpackcompose.network.model

import com.example.example.bookshelf.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxReslts: Int
    ): BookShelf

}