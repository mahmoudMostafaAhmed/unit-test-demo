package com.ibtikar.unittestdemo

class LoginPresenterImpl : LoginPresenter {

    private var loginView: LoginView? = null
    private var email: String? = null
    private var password: String? = null

    override fun onGetEmail(email: String) {
        this.email = email
    }

    override fun onGetPassword(password: String) {
        this.password = password
    }

    override fun onLoginClicked() {

        if (email.isNullOrEmpty()) {
            loginView!!.showError(R.string.email_error)
            return
        }

        if (!email!!.contains("@") && !email!!.contains(".")) {
            loginView!!.showError(R.string.email_not_valid)
            return
        }

        if (password.isNullOrEmpty()) {
            loginView!!.showError(R.string.password_error)
            return
        }

        if (password!!.length < 4) {
            loginView!!.showError(R.string.password_not_valid)
            return
        }

        loginView!!.validateSuccess(email!!, password!!)
    }

    override fun attachView(loginView: LoginView) {
        this.loginView = loginView
    }

    override fun detachView() {
        this.loginView = null
    }


}