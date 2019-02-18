package com.ibtikar.unittestdemo

interface LoginView {

    fun validateSuccess(email: String, password: String)
    fun showError(msg: Int)
}