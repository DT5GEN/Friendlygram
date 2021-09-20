package com.example.friendlygram.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.friendlygram.R
import com.example.friendlygram.utitits.AppTextWatcher
import com.example.friendlygram.utitits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher{
                val string = register_input_code.text.toString()
                if (string.length == 6) {
                    verifiCode()
                }
           })
    }

    fun verifiCode() {
        showToast("O.k.")
    }

}