package com.ponsingh.myapplication.user.list

import com.ponsingh.myapplication.user.details.toCamelCase

class UserListModel {
    val name: String = ""
    val email: String = ""
    val id = 0
    fun getNameCamelCase() = name.toCamelCase()
}