package com.mobile.fintech.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mobile.fintech.R

class MainActivityMVP : AppCompatActivity(), MainView {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var btHitungLuas: Button
    private lateinit var btHitungKeliling: Button
    private lateinit var tvHasil: TextView
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp)

        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.etpanjang)
        etLebar = findViewById(R.id.etlebar)
        btHitungLuas = findViewById(R.id.btLuas)
        btHitungKeliling = findViewById(R.id.btKeliling)
        tvHasil = findViewById(R.id.tvhasil)

        btHitungLuas.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungLuasPersegiPanjang(panjang, lebar)
        }

        btHitungKeliling.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegiPanjang(panjang, lebar)
        }

    }

    override fun updateLuas(luas:Float) {
        tvHasil.text = luas.toString()
    }

    override fun updateKeliling(keliling : Float) {
        tvHasil.text = keliling.toString()
    }

    override fun showError(errorMsg: String) {
        tvHasil.text = errorMsg
    }

}

