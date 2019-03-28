package com.example.loginer.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.loginer.R
import kotlinx.android.synthetic.main.activity_success_login.view.*

class SuccessLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_login)
        findViewById<Button>(R.id.back_button).setOnClickListener { onBackPressed() }
    }

}
