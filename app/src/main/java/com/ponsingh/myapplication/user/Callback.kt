package com.ponsingh.myapplication.user

import com.ponsingh.myapplication.user.list.UserListModel

interface Callback {
    fun onSuccess(data:ArrayList<UserListModel>)
    fun onError(error:String)



}