package com.ibtikar.unittestdemo

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class LoginPresenterImplTest {

    private lateinit var presenter: LoginPresenter
    private lateinit var view: LoginView

    @Before
    fun setup() {
        presenter = LoginPresenterImpl()
        view = mock()
        presenter.attachView(view)
    }

    @Test
    fun loginWithNullEmailCallsShowEmailError() {
        presenter.onLoginClicked()
        verify(view).showError(R.string.email_error)
    }

    @Test
    fun loginWithEmptyEmailCallsShowEmailError() {
        presenter.onGetEmail("")
        presenter.onLoginClicked()
        verify(view).showError(R.string.email_error)
    }

    @Test
    fun loginWithInvalidEmailCallsShowEmailError() {
        presenter.onGetEmail("mah")
        presenter.onLoginClicked()
        verify(view).showError(R.string.email_not_valid)
    }

    @Test
    fun loginWithEmptyPasswordCallsShowPasswordError() {
        presenter.onGetEmail("mah@c.v")
        presenter.onLoginClicked()
        verify(view).showError(R.string.password_error)
    }

    @Test
    fun loginWithInvalidPasswordCallsShowPasswordError() {
        presenter.onGetEmail("mah@c.v")
        presenter.onGetPassword("000")
        presenter.onLoginClicked()
        verify(view).showError(R.string.password_not_valid)
    }

    @Test
    fun loginWithValidDataCallsValidateSuccess() {
        presenter.onGetEmail("mah@c.v")
        presenter.onGetPassword("0000")
        presenter.onLoginClicked()
        verify(view).validateSuccess("mah@c.v", "0000")
    }

    @Test
    fun searchWithEmptyDataDoesNotCallsValidateSuccess() {
        verify(view, never()).validateSuccess(anyString(), anyString())
    }
}