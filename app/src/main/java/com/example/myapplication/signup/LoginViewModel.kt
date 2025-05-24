package com.example.myapplication.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.User
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val repo = LoginRepo(application)
    val user: MutableLiveData<User> = MutableLiveData()

    fun storeUserData(user: User) {
        viewModelScope.launch {
            repo.storeUserInfoToDb(user)
        }
    }

    fun getUserInfo(email: String) {
       viewModelScope.launch {
           user.value = repo.getUserInfo(email)
        }
    }

}