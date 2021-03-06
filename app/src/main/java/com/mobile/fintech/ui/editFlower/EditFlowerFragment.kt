package com.mobile.fintech.ui.editFlower

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.mobile.fintech.R
import com.mobile.fintech.data.local.database.AppDatabase
import com.mobile.fintech.data.local.database.dao.FlowerDao
import com.mobile.fintech.data.local.database.model.FlowerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_FLOWER_ID = "param_flower_id"
private const val ARG_FLOWER_NAME = "param_flower_name"
private const val ARG_FLOWER_IMAGE = "param_flower_image"

class EditFlowerFragment : Fragment() {

    private var flowerId: Int = 0
    private var flowerName: String = ""
    private var flowerImageUrl: String = ""

    private lateinit var etFlowerName: EditText
    private lateinit var etFlowerUrl: EditText
    private lateinit var btnSaveFlower: Button
    private lateinit var btnDeleteFlower: Button

    private lateinit var flowerDao: FlowerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var flowerId: Int = 0
            var flowerName: String = ""
            var flowerImageUrl: String = ""
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etFlowerName = view.findViewById(R.id.et_flower_name)
        etFlowerUrl = view.findViewById(R.id.et_flower_url)
        btnSaveFlower = view.findViewById(R.id.btn_save)
        btnDeleteFlower = view.findViewById(R.id.btn_delete)
        etFlowerName.setText(flowerName)
        etFlowerUrl.setText(flowerImageUrl)

        btnSaveFlower.setOnClickListener {
            updateFlower(etFlowerName.text.toString(), etFlowerUrl.text.toString())
        }
        btnDeleteFlower.setOnClickListener {
            deleteFlower()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        flowerDao = AppDatabase.newInstance(requireContext()).flowerDao()
        return inflater.inflate(R.layout.fragment_edit_flower, container, false)
    }

    private fun updateFlower(flowerName: String, flowerUrl: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                flowerDao.updateFlower(
                    flower = FlowerEntity(
                        id = flowerId ?: 0,
                        flowerName = flowerName,
                        flowerImageUrl = flowerUrl
                    )
                )
            }catch (e: Exception) {
                Log.e("EditFlowerFragment", "updateFlower: ", e)
            }
            withContext(Dispatchers.Main) {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun deleteFlower() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                flowerDao.deleteFlower(
                    flower = FlowerEntity(
                        id = flowerId,
                        flowerName = flowerName,
                        flowerImageUrl = flowerImageUrl
                    )
                )
            }catch (e: Exception) {
                Log.e("EditFlowerFragment", "deleteFlower: ", e)
            }
            withContext(Dispatchers.Main) {
                requireActivity().onBackPressed()
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(flowerId: Int, flowerName: String, flowerImage: String) =
            EditFlowerFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_FLOWER_ID, flowerId)
                    putString(ARG_FLOWER_NAME, flowerName)
                    putString(ARG_FLOWER_IMAGE, flowerImage)
                }
            }
    }
}