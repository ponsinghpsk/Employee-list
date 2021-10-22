package com.ponsingh.myapplication.user

import com.ponsingh.myapplication.api.Api
import com.ponsingh.myapplication.user.details.CallbackDetail
import com.ponsingh.myapplication.user.details.UserModel
import com.ponsingh.myapplication.user.list.UserListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {

/*suspend fun getUser(){
    withContext(Dispatchers.IO){
        try{
            val apiCall: UserApi = Api.getApi().create(UserApi::class.java)
            apiCall.getUsers()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}*/
   fun getUser(callback: com.ponsingh.myapplication.user.Callback) {
        val apiCall: UserApi = Api.getApi().create(UserApi::class.java)
        apiCall.getUsers().enqueue(object : Callback<ArrayList<UserListModel>> {
            override fun onResponse(
                call: Call<ArrayList<UserListModel>>,
                response: Response<ArrayList<UserListModel>>
            ) {
                response.body()?.let { callback.onSuccess(it) } ?: kotlin.run {
                    callback.onError("Network Error")
                }

            }

            override fun onFailure(call: Call<ArrayList<UserListModel>>, t: Throwable) {
                t.message?.let { callback.onError(it) }

            }

        })
    }

    fun getDetail(callback: CallbackDetail, id: Int) {
        val apiCall: UserApi = Api.getApi().create(UserApi::class.java)
        apiCall.getDetails(id).enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                response.body()?.let {
                    callback.onSuccess(it)
                } ?: kotlin.run {
                    callback.onError("Network Error ")
                }

            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                t.message?.let { callback.onError(it) }
            }
        })
    }
}

