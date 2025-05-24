package com.example.myapplication.signup

import android.content.Context
import com.example.myapplication.data.User
import com.example.myapplication.db.AppDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepo(
    private val context: Context,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val dbInstance = AppDatabase.getInstance(context = context.applicationContext)

    suspend fun storeUserInfoToDb(user: User) {
        withContext(dispatcher) {
            dbInstance.userDao().insertToUserDB(user = user)
        }
    }

    suspend fun getUserInfo(email : String) : User? {
       return withContext(dispatcher) {
            dbInstance.userDao().getUserInfo(emailId = email)
        }
    }
}