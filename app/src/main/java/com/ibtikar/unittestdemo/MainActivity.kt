package com.ibtikar.unittestdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {

    private val presenter: LoginPresenter = LoginPresenterImpl()

    override fun validateSuccess(email: String, password: String) {

    }

    override fun showError(msg: Int) {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        login.setOnClickListener {
            presenter.onGetEmail(email.text.toString())
            presenter.onGetPassword(password.text.toString())
            presenter.onLoginClicked()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}
