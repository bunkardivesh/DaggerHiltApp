package com.divesh.daggerhiltapp.data.api

import com.divesh.daggerhiltapp.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUser(): Response<List<User>>
}