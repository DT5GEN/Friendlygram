package com.example.friendlygram.ui.fragments

import android.view.View
import com.example.friendlygram.R
import com.example.friendlygram.models.CommonModel
import com.example.friendlygram.utitits.APP_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.view.*


class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.VISIBLE

    }

    override fun onPause() {
        super.onPause()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.GONE

    }
}
