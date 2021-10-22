package com.ponsingh.myapplication.user.details

import java.lang.StringBuilder
import java.util.*

data class UserModel(
    val id: Int, val name: String, val email: String, val phone: String,
    val website: String, val address: AddressModel, val company: CompanyModel
) {
    fun getDetail(): String {
        val builder = StringBuilder()
        builder.append("Employee Id: ").append(id).append("\n\n")
            .append("Name: ").append(name.toCamelCase())
        return builder.toString()
    }

    fun getAddressText(): String {
        val builder = StringBuilder()
        builder.append("Address: ").append("\n")
            .append(" ").append(address.street).append(", ").append(address.suite).append(", ")
            .append("\n")
            .append(" ").append(address.city).append("-").append(address.zipcode)
        return builder.toString()
    }

    fun getPhoneNumber() = "Phone Number: $phone"
    fun getEmailAddress() = "Email: ${email.lowercase()}"
    fun getCompanyDetails(): String {
        val builder = StringBuilder()
        builder.append("Company Details: ").append("\n")
            .append(" ").append("Company Name: ").append(company.name).append("\n")
            .append(" ").append("Website: ").append(website)
        return builder.toString()
    }

}

data class CompanyModel(val name: String)

data class AddressModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
)


fun String.toCamelCase(): String {
    val words = split(" ").toMutableList()
    var output = ""
    for (word in words) {
        output += word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } + " "
    }
    return output.trim()
}