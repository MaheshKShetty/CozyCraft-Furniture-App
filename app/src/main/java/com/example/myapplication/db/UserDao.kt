package com.example.myapplication.db

import androidx.room.Insert
import com.example.myapplication.data.User

interface UserDao {

    @Insert
    fun insertToUserDB(user: User) : Long


}