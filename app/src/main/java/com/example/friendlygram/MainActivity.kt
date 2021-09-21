package com.example.friendlygram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.friendlygram.activities.RegisterActivity
import com.example.friendlygram.databinding.ActivityMainBinding
import com.example.friendlygram.ui.fragments.ChatFragment
import com.example.friendlygram.ui.objects.AppDrawer
import com.example.friendlygram.utitits.AUTH
import com.example.friendlygram.utitits.initFirebase
import com.example.friendlygram.utitits.replaceActivity
import com.example.friendlygram.utitits.replaceFragment

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
            replaceActivity(RegisterActivity())

        }


    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this,mToolbar)
        initFirebase()

    }
}