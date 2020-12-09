package com.example.mode.repository

import com.example.mode.API.ChuckNorrisJokes_API
import com.example.mode.database.JokeDatabase

class JokeRepository
    (private val ChuckNorrisJokes_API: ChuckNorrisJokes_API,
     private val database: JokeDatabase
) {
}