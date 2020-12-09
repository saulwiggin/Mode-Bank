package com.example.mode.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mode.domain.Joke

@Entity
data class DatabaseJoke(
    @PrimaryKey
    var id: Int,
    var joke: String
)
