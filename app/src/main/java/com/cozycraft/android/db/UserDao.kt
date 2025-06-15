package com.cozycraft.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cozycraft.android.data.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertToUserDB(user: User) : Long

    @Query("SELECT * FROM user WHERE email IN (:emailId)")
    fun getUserInfo(emailId: String): User?

}