package com.mobile.fintech.ui.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import com.mobile.fintech.R
import com.mobile.fintech.data.local.sharedpref.PrefUtil


class SettingFragment : Fragment() {

    private lateinit var prefUtil: PrefUtil
    private lateinit var switchDarkMode: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switchDarkMode = view.findViewById(R.id.switch_darkmode)
        switchDarkMode.isChecked = prefUtil.getBoolean(ENABLE_DARKMODE)
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            prefUtil.saveboolean(ENABLE_DARKMODE, isChecked)
            val nightMode = if (isChecked) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(nightMode)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        prefUtil = PrefUtil.newInstance(requireContext())
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    companion object {
        const val ENABLE_DARKMODE = "enable_darkmode"
    }
}