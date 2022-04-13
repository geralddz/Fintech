package com.mobile.fintech.ui.profile

import com.mobile.fintech.model.User

class ProfilePresenter(private val view:ProfileView) {

    fun loadUserProfile(userId: Int) {
        try {
            view.showUserProfile(
                User(
                    email = "dz_gerald@gmail.com",
                    id = userId,
                    imageUrl = "https://d.newsweek.com/en/full/1061787/donald-trump-approval-rating.jpg",
                    name = "Gerald Dzulfiqar"
                )
            )
        } catch (e: Exception) {
            view.failedLoadUserProfile("Gagal Mengambil Data!")
        }
    }
}