package com.example.friendlygram.utitits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.friendlygram.R
import com.example.friendlygram.activities.RegisteActivity
import com.example.friendlygram.ui.fragments.ChatFragment

fun Fragment.showToast( message:String){
    Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    val intent = Intent(this,activity::class.java)
    startActivity(intent)
    this.finish()

}

fun AppCompatActivity.replaceFragment(fragment: Fragment,  addStack:Boolean = true){
        if (addStack){
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.dataContainer, fragment).commit()

        } else {

            supportFragmentManager.beginTransaction()
                .replace(R.id.dataContainer, fragment).commit()


        }


}

fun Fragment.replaceFragment(fragment: Fragment){

    this.activity?.supportFragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.dataContainer, fragment)?.commit()


}

