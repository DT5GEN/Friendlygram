package com.example.friendlygram.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.friendlygram.R
import com.example.friendlygram.activities.RegisterActivity
import com.example.friendlygram.utitits.*
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {


   /* private var launcherImageChoose: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultPhoto ->
            if (resultPhoto.resultCode == RESULT_OK && resultPhoto.resultCode != null ) {
                val uri = CropImage.getActivityResult(resultPhoto.data!!).uri
                val path = REF_STORAGE_ROOT.child(FOLDER_PROFILE_IMAGE)
                    .child(CURRENT_UID)
                path.putFile(uri).addOnCompleteListener { task1 ->
                    if (task1.isSuccessful){
                        path.downloadUrl.addOnCompleteListener { task2 ->
                            if (task2.isSuccessful){
                                val photoUrl = task2.result.toString()
                                REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID)
                                    .child(CHILD_PHOTO_URL).setValue(photoUrl)
                                    .addOnCompleteListener {
                                        if (it.isSuccessful){
                                            settings_user_photo.downloadAndSetImage(photoUrl)
                                            showToast("o.k.")
                                            USER.photoUrl = photoUrl

                                        }
                                    }
                            }

                        }
                    }
                }
            }
        }*/

   /* private fun changePhotoUser(){
        launcherImageChoose.launch(
            CropImage.activity()
                .setAspectRatio(1,1)
                .setRequestedSize(250,250)
                .setCropShape(CropImageView.CropShape.OVAL)
                .getIntent(APP_ACTIVITY)


        )
    }*/



    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

        initFields()

    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_status.text = USER.state
        settings_username.text = USER.username
        settings_btn_change_username.setOnClickListener { replaceFragment(ChangeUsernameFragment()) }
        settings_btn_change_bio.setOnClickListener { replaceFragment(ChangeBioFragment()) }
        settings_change_photo.setOnClickListener { changePhotoUser() }
        settings_user_photo.downloadAndSetImage(USER.photoUrl)

    }

    private fun changePhotoUser() {
        CropImage.activity()
            .setAspectRatio(1,1)
            .setRequestedSize(600,600)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(APP_ACTIVITY,this)



    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings_menu_exit -> {
                AppStates.updateState(AppStates.OFFLINE)
                AUTH.signOut()
                APP_ACTIVITY.replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            val uri = CropImage.getActivityResult(data).uri
            val path = REF_STORAGE_ROOT.child(FOLDER_PROFILE_IMAGE)
                .child(CURRENT_UID)

            putImageToStorage(uri, path) {
                getUrlToStorage(path){
                    putUrlToDatabase(it){
                        settings_user_photo.downloadAndSetImage(it)
                        showToast(getString(R.string.toast_data_update))
                        USER.photoUrl = it
                        APP_ACTIVITY.mAppDrawer.updateHeader()

                    }
                }
            }
        }
    }






}