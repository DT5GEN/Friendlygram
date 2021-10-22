package com.example.friendlygram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.friendlygram.MainActivity
import com.example.friendlygram.utitits.APP_ACTIVITY


open class BaseFragment(layout:Int) : Fragment(layout) {



    override fun onStart() {
        super.onStart()
        (APP_ACTIVITY).mAppDrawer.disableDrawer()
    }


}