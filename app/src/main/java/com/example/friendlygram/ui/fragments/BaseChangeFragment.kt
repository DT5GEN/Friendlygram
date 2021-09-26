package com.example.friendlygram.ui.fragments

import android.view.*
import androidx.fragment.app.Fragment
import com.example.friendlygram.MainActivity
import com.example.friendlygram.R
import com.example.friendlygram.utitits.APP_ACTIVITY


open class BaseChangeFragment(layout:Int) : Fragment(layout) {


    override fun onStart() {
        setHasOptionsMenu(true)
        super.onStart()
        (APP_ACTIVITY).mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        APP_ACTIVITY.hideKeyboard()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (APP_ACTIVITY).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_confirm_change -> change()
        }
        return true


    }

    open fun change() {

    }

}
