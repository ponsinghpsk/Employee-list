package com.ponsingh.myapplication.user

import com.ponsingh.myapplication.user.details.UserModel
import com.ponsingh.myapplication.user.list.UserListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface  UserApi {
     @GET("users")
     fun getUsers():Call<ArrayList<UserListModel>>
     @GET("users/{id}")
     fun getDetails(@Path("id") id: Int):Call<UserModel>


}