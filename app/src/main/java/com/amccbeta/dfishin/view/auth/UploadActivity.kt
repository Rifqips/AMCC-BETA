package com.amccbeta.dfishin.view.auth

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import com.amccbeta.dfishin.data.model.user.User
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.ActivityUploadBinding
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.cast.framework.media.ImagePicker
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.*

class UploadActivity : AppCompatActivity(),PermissionListener {

    private lateinit var binding: ActivityUploadBinding


    var statusAdd: Boolean = false
    lateinit var filePath: Uri

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance : FirebaseDatabase
    lateinit var storageReference : StorageReference
    lateinit var preferences : PreferencesClass


    lateinit var sUsername : String
    lateinit var sPassword : String
    lateinit var sEmail : String
    lateinit var sUrl : String


    private var imageMultiPart: MultipartBody.Part? = null
    private var imageFile: File? = null
    private var imageUri: Uri? = Uri.EMPTY



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = PreferencesClass(this)
        storageReference = Firebase.storage.reference
        mFirebaseInstance = FirebaseDatabase.getInstance()
        mFirebaseDatabase = mFirebaseInstance.getReference("user")

//        binding.imageView4.setOnClickListener {
//            startActivity(Intent(this@UploadActivity, AuthActivity::class.java))
//        }



        binding.btnAction.setOnClickListener{

            sUsername = binding.edName.text.toString()
            sPassword = binding.edPassword.text.toString()
            sEmail = binding.edEmail.text.toString()
            sUrl = binding.ivProfile.toString()

            // membuat proggres dialog
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            // dengan folder yang ada di firebasenya
            val ref = storageReference.child("images/"+ UUID.randomUUID().toString())
            ref.putFile(filePath) // kasih filenya dengan uri tadi / filepath
                .addOnSuccessListener {
                    // jika sukses matikan progress dialognya
                    progressDialog.dismiss()

                    // untuk url nya di save ke share preferences
                    ref.downloadUrl.addOnSuccessListener {
                        preferences.setValue("url", it.toString())
                        // preferences.setValue("url", it.toString())
//                        saveToFirebase(it.toString())
                    }
                }

                // jika tidak sukses
                .addOnFailureListener{ e ->
                    progressDialog.dismiss()
                    Toast.makeText(this, "Failed" + e.message, Toast.LENGTH_LONG).show()
                }

                // untuk menampilkan berapa persen yang sudah terupload
                .addOnProgressListener {
                        taskSnapshot -> val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                    progressDialog.setMessage("Upload "+progress.toInt()+" %")
                }
            if ( binding.edName.equals("")){
                binding.edName.error = "Silakan isi username Anda"
                binding.edName.requestFocus()
            } else if (binding.edPassword.equals("")){
                binding.edPassword.error = "Silakan isi password Anda"
                binding.edPassword.requestFocus()
            }else if (binding.edEmail.equals("")){
                binding.edEmail.error = "Silakan isi nama Anda"
                binding.edEmail.requestFocus()
            } else {
                val statusUsername = binding.edName.text?.indexOf(".")
                if (statusUsername!! >=0) {
                    binding.edName.error = "Silahkan tulis Username Anda tanpa ."
                    binding.edName.requestFocus()
                } else {
                    saveUsername(sUsername, sPassword, sEmail, sUrl)
                }
            }

        }

        binding.ivAdd.setOnClickListener {
            openGallery()
        }
    }

    fun openGallery(){
        getContent.launch("image/*")
    }
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                val contentResolver: ContentResolver = this!!.contentResolver
                val type = contentResolver.getType(it)
                imageUri = it

                val fileNameimg = "${System.currentTimeMillis()}.png"

                val imageView = binding.ivProfile
                imageView.setImageURI(it)

                Toast.makeText(this, "$imageUri", Toast.LENGTH_SHORT).show()

                val tempFile = File.createTempFile("assignment-1", fileNameimg, null)
                imageFile = tempFile
                val inputstream = contentResolver.openInputStream(uri)
                tempFile.outputStream().use    { result ->
                    inputstream?.copyTo(result)
                }
                val requestBody: RequestBody = tempFile.asRequestBody(type?.toMediaType())
                imageMultiPart = MultipartBody.Part.createFormData("image", tempFile.name, requestBody)
            }
        }

    private fun saveUsername(sUsername: String, sPassword: String,  sEmail: String, sUrl: String) {
        val user = User()
        user.username = sUsername
        user.password = sPassword
        user.email = sEmail
<<<<<<< HEAD
=======
        user.telepon = sTelepon
>>>>>>> auth-fragment
        user.url = sUrl

        checkingUsername(sUsername, user)
    }

    private fun checkingUsername(sUsername: String, data: User) {
        mFirebaseDatabase.child(sUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mFirebaseDatabase.child(sUsername).setValue(data)

                val intent = Intent(this@UploadActivity,
                    DashboardActivity::class.java).putExtra("data", data.username)
                startActivity(intent)
                Toast.makeText(this@UploadActivity, "Sukses Register", Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@UploadActivity, ""+databaseError.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
        openGallery()
    }

    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
        Toast.makeText(this, "Anda tidak bisa menambahkan photo profile", Toast.LENGTH_LONG).show()
    }

    override fun onPermissionRationaleShouldBeShown(
        permission: com.karumi.dexter.listener.PermissionRequest?,
        token: PermissionToken?
    ) {
        TODO("Not yet implemented")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            Activity.RESULT_OK -> {
                // Image Uri will not be null for RESULT_OK
                statusAdd = true // status digunakan untuk menganti icon
                filePath = data?.data!!

                Glide.with(this)
                    .load(filePath)
                    .apply(RequestOptions.circleCropTransform())
                    .into(binding.ivProfile)

                //            binding.ivAdd.setImageResource(R.drawableb)
                binding.btnAction.isGone = false

            }
            ImagePicker.IMAGE_TYPE_LOCK_SCREEN_BACKGROUND -> {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }


}