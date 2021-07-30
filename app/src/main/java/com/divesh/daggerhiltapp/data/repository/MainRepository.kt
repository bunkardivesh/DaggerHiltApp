package com.divesh.daggerhiltapp.data.repository

import com.divesh.daggerhiltapp.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getUsers() = apiHelper.getUsers()
}