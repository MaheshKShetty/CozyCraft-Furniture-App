package com.cozycraft.android.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cozycraft.android.data.User
import com.cozycraft.android.R
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val repo = LoginRepo(application)
    val userLiveData: MutableLiveData<User> = MutableLiveData()
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _signupSuccess = MutableStateFlow(false)
    val signupSuccess: StateFlow<Boolean> = _signupSuccess

    fun storeUserData(user: User) {
        viewModelScope.launch {
            val userinfo = async { repo.getUserInfo(user.email) }.await()
            if (userinfo != null) {
                _signupSuccess.value = true
            } else {
                _signupSuccess.value = false
                _errorMessage.value = (getApplication() as Application).getString(R.string.email_error)
            }
        }
    }

    fun getUserInfo(email: String) {
        viewModelScope.launch {
            userLiveData.value = repo.getUserInfo(email)
        }
    }
}