package com.example.friendlygram.utitits

import android.app.Activity
import android.net.Uri
import android.view.View
//import androidx.activity.result.ActivityResult
import com.example.friendlygram.MainActivity

//class Intents(
//    ViewModel: MainViewModel,
//    mainActivity: MainActivity
//) {
//    private val mActivity = mainActivity
//    private val mViewModel = ViewModel
//    private lateinit var mPhotoUri: Uri
//    private lateinit var mFilename: String
//    private lateinit var mCurrentPhotoPath: String
//
//
//    fun cameraIntent(
//        result: ActivityResult,
//        mSingleChatFragment: FragmentSingleChatBinding,
//        id: String
//    ) {
//        if (result.resultCode == Activity.RESULT_OK) {
//            mSingleChatFragment.addContactsBtnToBottom.visibility = View.GONE
//            val messageKey = mViewModel.getMessageKey(id)
//            uploadFileToStorage(
//                uri = mPhotoUri,
//                messageKey = messageKey,
//                receivedID = id,
//                typeMessage = TYPE_MESSAGE_IMAGE,
//                pathStorage = mCurrentPhotoPath,
//                filename = mFilename
//            )
//        }
//    }
//
//
//    fun imageIntent(
//        result: ActivityResult,
//        mSingleChatFragment: FragmentSingleChatBinding,
//        id: String
//    ) {
//        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
//            mSingleChatFragment.addContactsBtnToBottom.visibility = View.GONE
//            val mImagePath = result.data!!.data!!
//            val path = getRealPathFromURI(mImagePath)
//            if (path != "") {
//                val messageKey = mViewModel.getMessageKey(id)
//                val filename = getFileNameFromUri(mImagePath)
//                uploadFileToStorage(
//                    uri = mImagePath,
//                    messageKey = messageKey,
//                    receivedID = id,
//                    typeMessage = TYPE_MESSAGE_IMAGE,
//                    pathStorage = path,
//                    filename = filename
//                )
//            }
//        }
//    }
//
//
//    fun fileIntent(
//        result: ActivityResult,
//        id: String
//    ) {
//        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
//            val uri = result.data!!.data
//            val messageKey =
//                mViewModel.getMessageKey(id)
//            val filename = getFileNameFromUri(uri!!)
//            uploadFileToStorage(
//                uri = uri,
//                messageKey = messageKey,
//                receivedID = id,
//                typeMessage = TYPE_MESSAGE_FILE,
//                filename = filename
//            )
//        }
//    }
//
//
//    fun attachFile(launcherFileChoose: ActivityResultLauncher<Intent>) {
//        val intent = Intent(Intent.ACTION_GET_CONTENT)
//        intent.type = "*/*"
//        launcherFileChoose.launch(intent)
//    }
//
//
//    fun startImageChooser(launcherImageChoose: ActivityResultLauncher<Intent>) {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_PICK
//        launcherImageChoose.launch(intent)
//    }
//
//
//    fun startCameraChooser(launcherCameraChoose: ActivityResultLauncher<Intent>) {
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        val photoFile: File? = try {
//            createFile()
//        } catch (ex: IOException) {
//            null
//        }
//        if (photoFile != null) {
//            mPhotoUri = FileProvider.getUriForFile(
//                mActivity,
//                "com.asp424.fileprovider",
//                photoFile
//            )
//            intent.putExtra(
//                MediaStore.EXTRA_OUTPUT,
//                mPhotoUri
//            )
//            launcherCameraChoose.launch(intent)
//        }
//    }
//
//
//    private fun createFile(): File {
//        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
//        val storageDir: File? = mActivity.getExternalFilesDir(Environment.DIRECTORY_DCIM)
//        return File.createTempFile(
//            "JPEG_${timeStamp}_",
//            ".jpg",
//            storageDir
//        ).apply {
//            mFilename = name
//            mCurrentPhotoPath = absolutePath
//        }
//    }
//}