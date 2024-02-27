package com.example.test.network

import com.example.test.models.PostListResponse
import com.example.test.models.PostListResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): List<PostListResponseItem>
}

/*
interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<PostListResponse>
}*/
