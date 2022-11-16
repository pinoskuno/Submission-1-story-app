package com.example.storyappsubmission1.ViewModel
import android.util.Log
import androidx.lifecycle.*
import com.storyappsubmission1.Data.API.Config
import com.storyappsubmission1.Data.Functon.Preference
import com.storyappsubmission1.Data.Response.ListStoryR
import com.storyappsubmission1.Data.Response.LoginResult
import com.storyappsubmission1.Data.Response.StoryR
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainVM (private val pref: Preference) : ViewModel() {
    private val _listStoryItems = MutableLiveData<List<ListStoryR>>()
    val listStoryItems: LiveData<List<ListStoryR>> = _listStoryItems

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUser(): LiveData<LoginResult> {
        return pref.getUser().asLiveData()
    }

    fun deleteUser() {
        viewModelScope.launch {
            pref.deleteUser()
        }
    }

    fun getStories(token: String) {
        _isLoading.value = true
        val client = Config.getApiService().getStories("Bearer $token")
        client.enqueue(object : Callback<StoryR> {
            override fun onResponse(call: Call<StoryR>, response: Response<StoryR>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listStoryItems.value = response.body()?.listStory
                } else {
                    Log.e(this@MainVM.toString(), "onFailure: ${response.message()}")
                }
            }



            override fun onFailure(call: Call<StoryR>, t: Throwable) {
                _isLoading.value = false
                Log.e(this@MainVM.toString(), "onFailure: ${t.message}")
            }
        })
    }
}