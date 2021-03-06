package com.example.friendlygram

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import com.example.friendlygram.activities.RegisterActivity
import com.example.friendlygram.databinding.ActivityMainBinding
import com.example.friendlygram.models.User
import com.example.friendlygram.ui.fragments.ChatFragment
import com.example.friendlygram.ui.objects.AppDrawer
import com.example.friendlygram.utitits.*
import com.theartofdev.edmodo.cropper.CropImage

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    lateinit var mAppDrawer: AppDrawer

    private lateinit var mToolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFirebase()
        initUser {
            initFields()
            initFunc()
        }

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

    }
}