package com.miyansoft.rickycharacter.data.api

import com.miyansoft.rickycharacter.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("/api/character")
     fun getUsers(): List<User>
}