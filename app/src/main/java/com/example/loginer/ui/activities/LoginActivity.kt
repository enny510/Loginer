package com.example.loginer.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.loginer.presentation.contracts.LoginContract

import kotlinx.android.synthetic.main.activity_login.*
import android.R.id
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.example.loginer.AndroidApplication
import com.example.loginer.R
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onSuccess() {
        val intent = Intent(this, SuccessLoginActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        AndroidApplication.component?.injects(this)
        presenter.attachView(this)

        val loginField = findViewById<EditText>(R.id.login_input)
        val passwordField = findViewById<EditText>(R.id.password_input)

        loginField.onTextChange {
            if(it.isNotBlank() && passwordField.text.isNotBlank())
                presenter.onDataGot(it.toString(), passwordField.text.toString())
        }

        passwordField.onTextChange {
            if(it.isNotBlank() && loginField.text.isNotBlank())
                presenter.onDataGot(loginField.text.toString(), it.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}

fun TextView.onTextChange(afterTextChanged: (Editable) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            afterTextChanged.invoke(p0)
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}
