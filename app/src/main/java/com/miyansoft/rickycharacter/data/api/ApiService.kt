package com.miyansoft.rickycharacter.data.api

import com.miyansoft.rickycharacter.data.model.Response
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {

    @GET("/api/character")
     fun getUsers(): Call<Response>
}