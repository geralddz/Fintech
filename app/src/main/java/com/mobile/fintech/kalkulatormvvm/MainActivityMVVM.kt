package com.mobile.fintech.kalkulatormvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobile.fintech.R

class MainActivityMVVM : AppCompatActivity() {

    private lateinit var tvHasil: TextView
    private lateinit var etInputSatu: EditText
    private lateinit var etInputDua: EditText
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvvm)

        val factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        tvHasil = findViewById(R.id.tv_hasil)
        etInputSatu = findViewById(R.id.et_input_satu)
        etInputDua = findViewById(R.id.et_input_dua)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnKali = findViewById(R.id.btn_kali)
        btnBagi = findViewById(R.id.btn_bagi)

        mainViewModel.hasil.observe(this) { hasil ->
            etInputSatu.setText("0.0")
            etInputDua.setText("0.0")
            tvHasil.text = hasil.toString()
        }
        btnTambah.setOnClickListener {
            mainViewModel.tambah(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnKurang.setOnClickListener {
            mainViewModel.kurang(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnKali.setOnClickListener {
            mainViewModel.kali(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
        btnBagi.setOnClickListener {
            mainViewModel.bagi(
                etInputSatu.text.toString().toFloat(),
                etInputDua.text.toString().toFloat()
            )
        }
    }
}