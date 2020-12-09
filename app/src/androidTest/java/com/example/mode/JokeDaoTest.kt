package com.example.mode

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.example.mode.database.DatabaseJoke
import com.example.mode.database.JokeDao
import com.example.mode.database.JokeDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class JokeDaoTest {

    @get: Rule
    var instantTaskExecuteRule = InstantTaskExecutorRule()

    private lateinit var database: JokeDatabase
    private lateinit var dao: JokeDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            JokeDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.jokeDao
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertJoke() = runBlockingTest{
        val jokeItem = DatabaseJoke(1, "joke")
        dao.insertAll(listOf(jokeItem))
        val allJoke = dao.getLocalDBJokes().getOrAwaitValue()
        assertThat(allJoke).contains(jokeItem)
    }
}