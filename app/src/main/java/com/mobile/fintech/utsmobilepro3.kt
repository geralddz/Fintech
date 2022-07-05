package com.mobile.fintech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class utsmobilepro3 : AppCompatActivity() {
    private lateinit var btntampil1 : Button
    private lateinit var etNama1 : EditText
    private lateinit var etEmail1 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utsmobilepro3)

        btntampil1 = findViewById(R.id.bttampil1)
        etNama1 = findViewById(R.id.etnama1)
        etEmail1 = findViewById(R.id.etemail1)
        btntampil1.setOnClickListener {
            val fragment = utsfragment()
            val Bundle = Bundle()
            Bundle.putString("nama",etNama1.text.toString())
            Bundle.putString("email",etEmail1.text.toString())
            fragment.arguments = Bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentuts,fragment).commit()
        }
    }
}
