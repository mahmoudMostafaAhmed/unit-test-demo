package com.ibtikar.unittestdemo

interface LoginPresenter {

    fun onGetEmail(email: String)

    fun onGetPassword(password: String)

    fun onLoginClicked()

    fun attachView(loginView: LoginView)

    fun detachView()

}