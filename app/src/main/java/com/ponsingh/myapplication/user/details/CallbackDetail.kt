package com.ponsingh.myapplication.user.details

interface CallbackDetail {
    fun onSuccess(data:UserModel)
    fun onError(error:String)
}