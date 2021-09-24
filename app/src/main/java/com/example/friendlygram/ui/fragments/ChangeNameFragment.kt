package com.example.friendlygram.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.friendlygram.MainActivity
import com.example.friendlygram.R
import com.example.friendlygram.utitits.*
import kotlinx.android.synthetic.main.fragment_change_name.*

class ChangeNameFragment : Fragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()

setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
when (item.itemId) {
    R.id.settings_confirm_change -> changeName()
}
        return true


    }

    private fun changeName() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if(name.isEmpty()){
            showToast(getString(R.string.settings_toast_name_is_empty))

        } else {
            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful){
                         showToast(getString(R.string.toast_data_update))
                        USER.fullname = fullname
                        fragmentManager?.popBackStack()

                    }
                }

        }



    }
}