package com.storyappsubmission1.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.storyappsubmission1.Data.Functon.Preference
import com.storyappsubmission1.Data.Response.LoginResult
import kotlinx.coroutines.launch

class StoryVM(private val pref: Preference) : ViewModel() {
    fun getUser(): LiveData<LoginResult> {
        return pref.getUser().asLiveData()
    }

    fun deleteUser() {
        viewModelScope.launch {
            pref.deleteUser()
        }
    }
}