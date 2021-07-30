package com.divesh.daggerhiltapp.data.api

import com.divesh.daggerhiltapp.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}