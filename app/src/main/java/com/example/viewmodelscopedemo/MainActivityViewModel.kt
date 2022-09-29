package com.example.viewmodelscopedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscopedemo.model.User
import com.example.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {

    private var userRepository = UserRepository()
    private val _users: MutableLiveData<List<User>?> =
        MutableLiveData()
    val users: LiveData<List<User>?> = _users

    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>?
            withContext(Dispatchers.IO) {
                result = userRepository.getUsers()
            }
            _users.postValue(result)
        }
    }
}