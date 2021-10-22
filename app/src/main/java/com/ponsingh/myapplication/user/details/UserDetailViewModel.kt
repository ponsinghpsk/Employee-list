package com.ponsingh.myapplication.user.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ponsingh.myapplication.user.Callback
import com.ponsingh.myapplication.user.UserRepo
import com.ponsingh.myapplication.user.list.UserListModel

class UserDetailViewModel(application: Application,val id: Int) : AndroidViewModel(application),CallbackDetail {
     val detail= MutableLiveData<UserModel>()
     val error=MutableLiveData<String>()
    private val repo=UserRepo()
    init {
        repo.getDetail(this,id)
    }

    override fun onSuccess(data: UserModel) {
        detail.value=data
    }

    override fun onError(error: String) {
        this.error.value=error
    }

}
class ViewModelFactory(private val application: Application,private val id:Int) : ViewModelProvider.AndroidViewModelFactory(
    application
){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return  UserDetailViewModel(application,id) as T
    }
}