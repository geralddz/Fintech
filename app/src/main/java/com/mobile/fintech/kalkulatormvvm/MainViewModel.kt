package com.mobile.fintech.kalkulatormvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _hasil = MutableLiveData<Float>()
    val hasil: LiveData<Float> get() = _hasil

    fun tambah(inputSatu: Float, inputDua: Float){
        val hasil = inputSatu + inputDua
        _hasil.value = hasil
    }

    fun kurang(inputSatu: Float, inputDua: Float){
        val hasil = inputSatu - inputDua
        _hasil.value = hasil
    }
    // tambahan function Kali dan Bagi
    fun kali(inputSatu: Float, inputDua: Float){
        val hasil = inputSatu * inputDua
        _hasil.value = hasil
    }

    fun bagi (inputSatu: Float, inputDua: Float){
        val hasil = inputSatu / inputDua
        _hasil.value = hasil
    }
}