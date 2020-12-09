package com.example.mode.API

import com.example.mode.database.DatabaseJoke
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ChuckNorrisJokes_API {
    @GET(API_Calls.API_JOKE_LIST)
    fun getJokes(): Deferred<List<DatabaseJoke>>
}