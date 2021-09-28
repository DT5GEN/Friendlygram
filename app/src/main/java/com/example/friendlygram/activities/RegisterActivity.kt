package com.example.friendlygram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.widget.Toolbar
import com.example.friendlygram.R
import com.example.friendlygram.databinding.ActivityRegisteBinding
import com.example.friendlygram.ui.fragments.EnterPhoneNumberFragment
import com.example.friendlygram.utitits.initFirebase
import com.example.friendlygram.utitits.replaceActivity
import com.example.friendlygram.utitits.replaceFragment


class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisteBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisteBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()

    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}