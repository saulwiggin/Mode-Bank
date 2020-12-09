package com.example.mode.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface JokeDao {
    @Query("SELECT * FROM DatabaseJoke")
    fun getLocalDBJokes(): LiveData<List<DatabaseJoke>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(joke: List<DatabaseJoke>)
}

@Database(entities = [DatabaseJoke::class], version = 1, exportSchema=false)
abstract class JokeDatabase : RoomDatabase() {
    abstract val jokeDao: JokeDao
}