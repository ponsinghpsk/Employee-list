package com.ponsingh.myapplication.user.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ponsingh.myapplication.user.Callback
import com.ponsingh.myapplication.user.UserRepo

class UserListViewModel(application: Application) : AndroidViewModel(application), Callback {
    var listdata = MutableLiveData<ArrayList<UserListModel>>()
    var error = MutableLiveData<String>()

    private val repo = UserRepo()

    init {
        repo.getUser(this)
    }

    override fun onSuccess(data: ArrayList<UserListModel>) {
        listdata.value=data

    }

    override fun onError(error: String) {
        this.error.value=error
    }

}