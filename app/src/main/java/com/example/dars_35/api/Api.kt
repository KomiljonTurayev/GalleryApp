package com.example.dars_35.api

import com.example.dars_35.model.PhotoModel
import com.example.dars_35.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>

    @GET("photos")
    fun getPhotos():Call<List<PhotoModel>>

}