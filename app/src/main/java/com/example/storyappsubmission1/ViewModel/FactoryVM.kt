package com.storyappsubmission1.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.storyappsubmission1.ViewModel.MainVM
import com.storyappsubmission1.Data.Functon.Preference


class FactoryVM (private val pref: Preference) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainVM::class.java) -> {
                MainVM(pref) as T
            }
            modelClass.isAssignableFrom(LoginVM::class.java) -> {
                LoginVM(pref) as T
            }
            modelClass.isAssignableFrom(StoryVM::class.java) -> {
                StoryVM(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown Viewmodel Class: " + modelClass.name)
        }
    }

}