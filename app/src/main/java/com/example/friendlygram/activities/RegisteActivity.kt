package com.example.friendlygram.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.friendlygram.R
import com.example.friendlygram.databinding.ActivityRegisteBinding
import com.example.friendlygram.ui.fragments.EnterPhoneNumberFragment


class RegisteActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityRegisteBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisteBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        supportFragmentManager.beginTransaction()
            .add(R.id.registerDataContainer,EnterPhoneNumberFragment())
            .commit()


    }

}