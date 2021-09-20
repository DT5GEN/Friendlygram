package com.example.friendlygram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.friendlygram.activities.RegisteActivity
import com.example.friendlygram.databinding.ActivityMainBinding
import com.example.friendlygram.ui.fragments.ChatFragment
import com.example.friendlygram.ui.objects.AppDrawer
import com.example.friendlygram.utitits.AUTH
import com.example.friendlygram.utitits.replaceActivity
import com.example.friendlygram.utitits.replaceFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAppDrawer: AppDrawer

    private lateinit var mToolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {

        if(AUTH.currentUser!=null){

            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatFragment(), false)


        } else {
            replaceActivity(RegisteActivity())

        }


    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this,mToolbar)
        AUTH = FirebaseAuth.getInstance()

    }
}