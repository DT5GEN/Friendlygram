package com.example.friendlygram.utitits

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.friendlygram.MainActivity
import com.example.friendlygram.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_settings.*

fun showToast( message:String){
    Toast.makeText(APP_ACTIVITY,message,Toast.LENGTH_SHORT).show()
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
                .replace(R.id.data_container, fragment).commit()

        } else {

            supportFragmentManager.beginTransaction()
                .replace(R.id.data_container, fragment).commit()


        }


}

fun Fragment.replaceFragment(fragment: Fragment){

    this.activity?.supportFragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.data_container, fragment)?.commit()


}

fun hideKeyboard(){
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken,0)
}

fun ImageView.downloadAndSetImage(url:String){
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.drawable.default_photo)
        .into(this)
}

fun restartActivity() {

    val intent = Intent(APP_ACTIVITY, MainActivity::class.java)
    APP_ACTIVITY.startActivity(intent)
    APP_ACTIVITY.finish()
}