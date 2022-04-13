package com.mobile.fintech.ui.profile

import com.mobile.fintech.model.User

class ProfilePresenter(private val view:ProfileView) {

    fun loadUserProfile(userId: Int) {
        try {
            view.showUserProfile(
                User(
                    email = "dz_gerald@gmail.com",
                    id = userId,
                    imageUrl = "https://amikom.ac.id/public/docs/2016/logo_amikom_full_color.png",
                    name = "Gerald Dzulfiqar"
                )
            )
        } catch (e: Exception) {
            view.failedLoadUserProfile("Gagal Mengambil Data!")
        }
    }
}