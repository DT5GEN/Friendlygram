package com.example.friendlygram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.friendlygram.R
import com.example.friendlygram.utitits.APP_ACTIVITY


class ChatFragment : Fragment(R.layout.fragment_chat) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Чаты"
    }

}