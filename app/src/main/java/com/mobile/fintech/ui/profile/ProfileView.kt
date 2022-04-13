package com.mobile.fintech.ui.profile

import com.mobile.fintech.model.User

interface ProfileView {

    fun showUserProfile (user: User)
    fun failedLoadUserProfile (message: String)
    fun showUserById (id: Int)

}