package com.example.friendlygram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.friendlygram.MainActivity
import com.example.friendlygram.R
import com.example.friendlygram.activities.RegisteActivity
import com.example.friendlygram.utitits.AUTH
import com.example.friendlygram.utitits.AppTextWatcher
import com.example.friendlygram.utitits.replaceActivity
import com.example.friendlygram.utitits.showToast
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val phoneNumber: String, val  id: String) : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        (activity as RegisteActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher{
                val string = register_input_code.text.toString()
                if (string.length == 6) {
                    enterCode()
                }
           })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id,code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful){
                showToast("Добро пожаловать")
                (activity as RegisteActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())

        }
    }

}