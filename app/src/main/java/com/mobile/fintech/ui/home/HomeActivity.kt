package com.mobile.fintech.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.fintech.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = "Home Menu"
    }
}