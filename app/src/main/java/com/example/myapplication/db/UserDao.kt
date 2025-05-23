package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.data.User

@Dao
interface UserDao {

    @Insert
    fun insertToUserDB(user: User) : Long

}