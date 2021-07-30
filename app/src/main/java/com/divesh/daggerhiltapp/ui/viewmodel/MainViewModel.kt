package com.divesh.daggerhiltapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divesh.daggerhiltapp.data.model.User
import com.divesh.daggerhiltapp.data.repository.MainRepository
import com.divesh.daggerhiltapp.utils.NetworkHelper
import com.divesh.daggerhiltapp.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
): ViewModel(){

    private val _users = MutableLiveData<Resource<List<User>>>()

    val users: LiveData<Resource<List<User>>> get() = _users
    init {
        fetchUsers()
    }


    private fun fetchUsers(){

        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.getUsers().let {
                    if (it.isSuccessful){
                            _users.postValue(Resource.success(it.body()))

                    }else _users.postValue(Resource.error(it.errorBody().toString(),null))
                }
            }else _users.postValue(Resource.error("No Internet Connection",null))
        }

    }
}
