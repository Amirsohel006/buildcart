package com.buildcart.app.modules.signuofifteen.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityProfileBinding
import com.buildcart.app.modules.signuofifteen.`data`.viewmodel.SignUoFifteenVM
import com.buildcart.app.modules.signuosix.ui.SignUoSixActivity
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class ProfileActivity :
    BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {
  private val viewModel: SignUoFifteenVM by viewModels<SignUoFifteenVM>()
  private lateinit var sessionManager: SessionManager
  private lateinit var apiInterface: APIInterface
  private lateinit var accessToken:String

  private var name:String=""
  private var mobileNumber:String=""
  private var email:String=""
  private  var city: String=""
  private var pincode:String=""
  private var profile_picture:String=""

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoFifteenVM = viewModel
    sessionManager= SessionManager(this)
    apiInterface = APIManager.apiInterface

    accessToken=sessionManager.fetchAuthToken().toString()

    getProfiledata("Bearer $accessToken")

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnLogOut.setOnClickListener {
      sessionManager.clearTokens()
      sessionManager.clearSession()
      sessionManager.logout()

      val destIntent = SignUoSixActivity.getIntent(this, null)
      startActivity(destIntent)
      finishAffinity()
    }

    binding.editProfile.setOnClickListener {
      val editProfileIntent=Intent(this,AccountUpdate::class.java)
      editProfileIntent.putExtra("username",name)
      editProfileIntent.putExtra("phone_number",mobileNumber)
      editProfileIntent.putExtra("email",email)
      editProfileIntent.putExtra("profile_picture",profile_picture)
      editProfileIntent.putExtra("city",city)
      editProfileIntent.putExtra("zipcode",pincode)
      startActivity(editProfileIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_FIFTEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  fun getProfiledata(authorization: String){
    val call=apiInterface.getProfileDetails(authorization)
    call.enqueue(object : Callback<ProfileDataResponse> {
      override fun onResponse(call: Call<ProfileDataResponse>, response: Response<ProfileDataResponse>) {
        if (response.isSuccessful) {

          val loginResponse = response.body()
          if (loginResponse != null) {
            //Toast.makeText(this@ProfileActivity, "Profile Data Successfully Fetched", Toast.LENGTH_LONG).show()



            val file=APIManager.getImageUrl(loginResponse.response!!.photo.toString())
            //profile_picture= loginResponse.response!!.photo.toString()

            sessionManager.saveProfilePicture(file)

            name= loginResponse.response!!.fullName.toString()
            sessionManager.saveUserFullName(name)
            email= loginResponse.response!!.email.toString()
            sessionManager.saveUserEmail(email)
            city=loginResponse.response!!.city.toString()
            pincode=loginResponse.response!!.zipcode.toString()
            mobileNumber=loginResponse.response!!.mobileNumber.toString()
            sessionManager.saveUserMobile(mobileNumber)


            Picasso.get().load(file).transform(CircleCrop()).placeholder(R.drawable.default_profile_background).into(binding.imageEllipseProfile)

            binding.etFullName.text=name
            binding.etMobileNo.text=mobileNumber
            binding.etZipcode.text=pincode
            binding.etCity.text=city
            binding.etEmail.text=email

              //navigateToHomeActivity()
          } else {
            Toast.makeText(this@ProfileActivity, "Profile Data fetching failed", Toast.LENGTH_SHORT).show()
          }
        } else {
          Toast.makeText(this@ProfileActivity, "Profile Data fetching Failed", Toast.LENGTH_SHORT).show()
        }
      }
      override fun onFailure(call: Call<ProfileDataResponse>, t: Throwable) {
        Toast.makeText(this@ProfileActivity, "Profile Data fetching: ${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }


  // Circular crop transformation class
  class CircleCrop : Transformation {
    override fun key(): String {
      return "circleCrop"
    }

    override fun transform(source: Bitmap): Bitmap {
      val size = Math.min(source.width, source.height)
      val x = (source.width - size) / 2
      val y = (source.height - size) / 2

      val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
      if (squaredBitmap != source) {
        source.recycle()
      }

      val bitmap = Bitmap.createBitmap(size, size, source.config)
      val canvas = Canvas(bitmap)
      val paint = Paint()
      val shader = BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
      paint.shader = shader
      paint.isAntiAlias = true

      val radius = size / 2f
      canvas.drawCircle(radius, radius, radius, paint)

      squaredBitmap.recycle()
      return bitmap
    }
  }
}
