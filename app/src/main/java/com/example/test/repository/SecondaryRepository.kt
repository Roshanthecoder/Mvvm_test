package com.example.test.repository

import com.example.test.models.PostListResponse
import com.example.test.models.PostListResponseItem
import com.example.test.network.ApiInterface
import retrofit2.Response

class SecondaryRepository(private val apiInterface: ApiInterface) {

    suspend fun getposts(): List<PostListResponseItem> {
        return apiInterface.getPosts()
    }
}