package com.example.friendlygram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.friendlygram.MainActivity
import com.example.friendlygram.R
import com.example.friendlygram.activities.RegisteActivity
import com.example.friendlygram.utitits.AUTH
import com.example.friendlygram.utitits.replaceActivity


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisteActivity())
            }
        }
        return true
    }
}