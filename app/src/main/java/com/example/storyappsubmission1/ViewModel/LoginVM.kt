package com.storyappsubmission1.ViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.storyappsubmission1.Data.Functon.Preference
import com.storyappsubmission1.Data.Response.LoginResult
import kotlinx.coroutines.launch

class LoginVM(private val pref: Preference) : ViewModel() {
    fun setUser(loginResult: LoginResult) {
        viewModelScope.launch {
            pref.setUser(loginResult)
        }
    }
}