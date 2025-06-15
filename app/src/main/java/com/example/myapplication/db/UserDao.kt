package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertToUserDB(user: User) : Long

    @Query("SELECT * FROM user WHERE email IN (:emailId)")
    fun getUserInfo(emailId: String): User?

}