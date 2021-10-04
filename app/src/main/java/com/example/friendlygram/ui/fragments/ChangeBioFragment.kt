package com.example.friendlygram.ui.fragments

import com.example.friendlygram.R
import com.example.friendlygram.database.*
import com.example.friendlygram.utitits.*
import kotlinx.android.synthetic.main.fragment_change_bio.*

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()

        setBioToDatabase(newBio)
    }


}
