package com.buildcart.app.modules.signuoeleven.ui

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.RequestSignUpResponse
import com.buildcart.app.data.response.SignUpResponse
import com.buildcart.app.data.response.SignUpUpdateResponse
import com.buildcart.app.databinding.ActivitySignUoElevenBinding
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import com.buildcart.app.modules.signuoeleven.`data`.viewmodel.SignUoElevenVM
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import kotlin.String
import kotlin.Unit

class SignUoElevenActivity :
    BaseActivity<ActivitySignUoElevenBinding>(R.layout.activity_sign_uo_eleven) {
  private val viewModel: SignUoElevenVM by viewModels<SignUoElevenVM>()
  lateinit var profileImageView:ImageView
  lateinit var profileAddIcon:ImageView
  lateinit var fullNameEt:EditText
  lateinit var termsAndConditionsEt:CheckBox
  lateinit var emailET:EditText
  lateinit var etMobileNumber:TextView
  lateinit var cityEt:EditText
  lateinit var pincodeEt:EditText
  lateinit var addProfile:ImageView

  private lateinit var file:File


  private val pickImage = 100
  private lateinit var imageUri: Uri

  private lateinit var apiInterface: APIInterface

  var multipartImage: MultipartBody.Part? = null


  var fullName:String=""
  var email:String=""
  var city:String=""
  var pincode:String=""
  var mobileNumber:String=""
  var termsAndConditions:Boolean=false
  var profileImage:File?=null

  private lateinit var sessionManager: SessionManager

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoElevenVM = viewModel

    sessionManager= SessionManager(this)

    mobileNumber=intent.getStringExtra("mobile_number").toString()
    apiInterface=APIManager.apiInterface
    profileImageView=binding.imageViewEllipseOne
    profileAddIcon=binding.imageVector
    fullNameEt=binding.etFullName
    termsAndConditionsEt=binding.checkboxTermsAndConditions
    emailET=binding.etEmailId
    etMobileNumber=binding.etMobileNumber
    cityEt=binding.etCity
    pincodeEt=binding.etPincode
    addProfile=binding.imageVector
    etMobileNumber.text=mobileNumber

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

  }

  override fun setUpClicks(): Unit {
    binding.btnComplete.setOnClickListener {
      fullName=fullNameEt.text.toString()
      email=emailET.text.toString()
      termsAndConditions=termsAndConditionsEt.isChecked
     // mobileNumber=etMobileNumber.text.toString()
      city=cityEt.text.toString()
      pincode=pincodeEt.text.toString()

      //signUpUser(fullName,mobileNumber,city,pincode,profileImage,email,termsAndConditions)


      signUp()

      binding.progresBar.visibility=View.VISIBLE

    }


    binding.imageVector.setOnClickListener {
      val editImageView:ImageView=findViewById(R.id.imageVector)
      val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
      startActivityForResult(gallery, pickImage)
    }
  }



  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == RESULT_OK && requestCode == pickImage) {

      imageUri = data?.data!!
      profileImageView.setImageURI(imageUri)
      addProfile.visibility=View.GONE
      val selectedFileURI: Uri =imageUri
      file = getFile(this, imageUri)
      //file = File(selectedFileURI.path.toString())
      Log.d("", "File : " + file.name)
      //uploadedFileName = file.toString()
      println("upload file name ${file.absoluteFile}")

      Log.d("my location","$file")

    }
  }


//  fun signUpUser(fullName:String?,mobileNumber: String?,city:String?,pincode:String?,profileImage:File?,email:String?,isTermsAndConditionsAccepted:Boolean?){
//    val call=apiInterface.registerUser(fullName,mobileNumber,city,pincode,profileImage,email,isTermsAndConditionsAccepted)
//    call.enqueue(object : Callback<RequestSignUpResponse> {
//      override fun onResponse(call: Call<RequestSignUpResponse>, response: Response<RequestSignUpResponse>) {
//        if (response.isSuccessful) {
//
//          val loginResponse = response.body()
//          if (loginResponse != null) {
//            Toast.makeText(this@SignUoElevenActivity, "Otp Verified Successfully", Toast.LENGTH_LONG).show()
//           signUpToHomeActivity()
//          } else {
//            Toast.makeText(this@SignUoElevenActivity, "OTP Verification failed", Toast.LENGTH_SHORT).show()
//          }
//        } else {
//          Toast.makeText(this@SignUoElevenActivity, "OTP Verification Failed", Toast.LENGTH_SHORT).show()
//        }
//      }
//      override fun onFailure(call: Call<RequestSignUpResponse>, t: Throwable) {
//        Toast.makeText(this@SignUoElevenActivity, "OTP Verification Failed: ${t.message}", Toast.LENGTH_SHORT).show()
//      }
//    })
//  }




  private  fun signUp(
  ) {
    val map: MutableMap<String, RequestBody> = mutableMapOf()
    val name = createPartFromString(fullName)
    val email = createPartFromString(email)
    val phoneNumber = createPartFromString(mobileNumber)
    val city=createPartFromString(city)
    val pincode = createPartFromString(pincode)
    val termsAndConditions = createPartFromString(termsAndConditions.toString())

    map.put("full_name", name)
    map.put("mobile_number", phoneNumber)
    map.put("city", city)
    map.put("zipcode", pincode)
    map.put("email", email)
    map.put("terms_and_c", termsAndConditions)


    // Parsing any Media type file
    //file= imageUri.path?.let { File(it) }!!
    //val file = File(profileImage)
    val requestFile: RequestBody = RequestBody.create(
      "image/jpg".toMediaType(),
      file
    )
    multipartImage =
      MultipartBody.Part.createFormData("photo", file.getName(), requestFile)

    //val signUpResponse=SignUpResponse(name,phoneNumber,placeOfBirth,dateOfBirth,timeOfBirth,email,gender,fileBody)
    val call =  apiInterface.signUp(map, multipartImage!!)
    call.enqueue(object : Callback<SignUpUpdateResponse> {
      override fun onResponse(call: Call<SignUpUpdateResponse>, response: Response<SignUpUpdateResponse>) {
        if (response.isSuccessful) {
          binding.progresBar.visibility=View.GONE
          val responseBody = response.body()
          if (responseBody != null) {
            Toast.makeText(this@SignUoElevenActivity, "Registration successful", Toast.LENGTH_SHORT).show()
            //Log.d("response_message",responseBody.)
            Log.d("response_data",responseBody.toString())
            sessionManager.saveAuthToken(responseBody.access_token)
            sessionManager.saveRefreshToken(responseBody.refresh_token)
            signUpToHomeActivity()
            finishAffinity()
          } else {
            Toast.makeText(this@SignUoElevenActivity, "Registration failed", Toast.LENGTH_SHORT).show()
            Log.d(responseBody,"This fails in signup response")
            binding.progresBar.visibility=View.GONE
          }
        }
        else {
          Toast.makeText(this@SignUoElevenActivity, "Registration failed", Toast.LENGTH_SHORT).show()
          Log.d(response.message(),"This fails in registration response")
          binding.progresBar.visibility=View.GONE
        }
      }
      override fun onFailure(call: Call<SignUpUpdateResponse>, t: Throwable) {
        Toast.makeText(this@SignUoElevenActivity, "Registration failed: ${t.message}", Toast.LENGTH_SHORT).show()
        Log.d(t.message,"This fails in signup response")
        binding.progresBar.visibility=View.GONE
      }
    })
  }

  fun createPartFromString(stringData: String): RequestBody {
    return stringData.toRequestBody("text/plain".toMediaTypeOrNull())
  }


  @Throws(IOException::class)
  fun getFile(context: Context, uri: Uri): File {
    val destinationFilename =
      File(context.filesDir.path + File.separatorChar + queryName(context, uri))
    try {
      context.contentResolver.openInputStream(uri).use { ins ->
        createFileFromStream(
          ins!!,
          destinationFilename
        )
      }
    } catch (ex: Exception) {
      Log.e("Save File", ex.message!!)
      ex.printStackTrace()
    }
    return destinationFilename
  }

  fun createFileFromStream(ins: InputStream, destination: File?) {
    try {
      FileOutputStream(destination).use { os ->
        val buffer = ByteArray(4096)
        var length: Int
        while (ins.read(buffer).also { length = it } > 0) {
          os.write(buffer, 0, length)
        }
        os.flush()
      }
    } catch (ex: Exception) {
      Log.e("Save File", ex.message!!)
      ex.printStackTrace()
    }
  }

  private fun queryName(context: Context, uri: Uri): String {
    val returnCursor = context.contentResolver.query(uri, null, null, null, null)!!
    val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    returnCursor.close()
    return name
  }

  fun signUpToHomeActivity(){

    val destIntent = HomeOneContainerActivity.getIntent(this, null)
    startActivity(destIntent)
    finish()
  }
  companion object {
    const val TAG: String = "SIGN_UO_ELEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoElevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
