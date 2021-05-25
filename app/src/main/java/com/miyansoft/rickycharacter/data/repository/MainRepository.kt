package com.miyansoft.rickycharacter.data.repository

import com.miyansoft.rickycharacter.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}