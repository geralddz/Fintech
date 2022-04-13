package com.mobile.fintech.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mobile.fintech.R
import com.mobile.fintech.ui.home.HomeActivity
import com.mobile.fintech.ui.home.HomeFragment
import com.mobile.fintech.ui.profile.ProfileActivity
import com.mobile.fintech.ui.profile.ProfileFragment
import com.mobile.fintech.ui.setting.SettingActivity
import com.mobile.fintech.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btHome:Button
    private lateinit var btProfile:Button
    private lateinit var btSetting:Button

    private lateinit var btFragHome:Button
    private lateinit var btFragProfile:Button
    private lateinit var btFragSetting:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Main Menu"
        btHome = findViewById(R.id.btHome)
        btProfile = findViewById(R.id.btProfile)
        btSetting = findViewById(R.id.btSetting)
        btFragHome = findViewById(R.id.btFHome)
        btFragProfile = findViewById(R.id.btFProfile)
        btFragSetting = findViewById(R.id.btFSetting)

        btHome.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }
        btProfile.setOnClickListener {
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }
        btSetting.setOnClickListener {
            val i = Intent(this, SettingActivity::class.java)
            startActivity(i)
        }

        handlerfragment()

    }

    private fun handlerfragment(){
        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val settingActivity = SettingFragment()

        btFragHome.setOnClickListener {
            loadfragment(homeFragment)
        }
        btFragProfile.setOnClickListener {
            loadfragment(profileFragment)
        }
        btFragSetting.setOnClickListener {
            loadfragment(settingActivity)
        }
    }

    private fun loadfragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

}