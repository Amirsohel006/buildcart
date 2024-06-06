package com.buildcart.app.modules.signuoone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.response.RequestSignUpResponse
import com.buildcart.app.databinding.ActivitySignUoOneBinding
import com.buildcart.app.modules.home.ui.HomeActivity
import com.buildcart.app.modules.signuoone.`data`.viewmodel.SignUoOneVM
import com.buildcart.app.modules.signuosix.ui.SignUoSixActivity
import com.buildcart.app.modules.signuotwo.ui.SignUoTwoActivity
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SignUoOneActivity : BaseActivity<ActivitySignUoOneBinding>(R.layout.activity_sign_uo_one) {
  private val viewModel: SignUoOneVM by viewModels<SignUoOneVM>()
  private lateinit var apiInterface:APIInterface
  private var mobileNumber:String=""
  private var referralCode:String=""
  private var otp:String=""



  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoOneVM = viewModel

     apiInterface = APIManager.apiInterface

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.btnSignup.setOnClickListener {

      val etMobileNumber=findViewById<EditText>(R.id.txtEnterMobilenu)

      val refCodeEt=findViewById<EditText>(R.id.etReferralCode)

      mobileNumber= etMobileNumber.text.toString()
      referralCode= refCodeEt.text.toString()

      if (mobileNumber.isBlank()){
        Toast.makeText(this@SignUoOneActivity, "Please Enter the Mobile Number", Toast.LENGTH_SHORT).show()}
      else{
      makeSignUpRequestOTP(mobileNumber,referralCode)}

      binding.progresBar.visibility=View.VISIBLE
//      val destIntent = SignUoTwoActivity.getIntent(this, null)
//      startActivity(destIntent)
    }
    binding.txtLogin.setOnClickListener {
      val  i=Intent(this,SignUoSixActivity::class.java)
      startActivity(i)
      }

    }


  fun requestOTP(){

  }


  fun makeSignUpRequestOTP(mobileNumber: String?, referralCode: String?) {
    val call = apiInterface.signUpRequestOTP(mobileNumber, referralCode)
    call.enqueue(object : Callback<RequestSignUpResponse> {
      override fun onResponse(call: Call<RequestSignUpResponse>, response: Response<RequestSignUpResponse>) {
        binding.progresBar.visibility = View.GONE
        if (response.isSuccessful) {
          val loginResponse = response.body()
          if (loginResponse != null) {
            Toast.makeText(this@SignUoOneActivity, "OTP Sent Successfully: ${loginResponse.otp}", Toast.LENGTH_LONG).show()
            otp = loginResponse.otp.toString()
            navigateToOTPActivity()
          } else {
            Toast.makeText(this@SignUoOneActivity, "OTP Sending failed", Toast.LENGTH_SHORT).show()
          }
        } else {
          // Handle the case when the response is not successful
          if (response.code() == 400) {
            val errorBody = response.errorBody()?.string()
            if (errorBody != null) {
              try {
                val jsonObject = JSONObject(errorBody)
                val errorMsg = jsonObject.optString("error_msg", "Invalid Referral Code ")
                Toast.makeText(this@SignUoOneActivity, errorMsg, Toast.LENGTH_SHORT).show()
              } catch (e: JSONException) {
                Toast.makeText(this@SignUoOneActivity, "Error parsing error message", Toast.LENGTH_SHORT).show()
              }
            } else {
              Toast.makeText(this@SignUoOneActivity, "Unknown error occurred", Toast.LENGTH_SHORT).show()
            }
          } else {
            Toast.makeText(this@SignUoOneActivity, "OTP Sending Failed", Toast.LENGTH_SHORT).show()
          }
        }
      }

      override fun onFailure(call: Call<RequestSignUpResponse>, t: Throwable) {
        binding.progresBar.visibility = View.GONE
        Toast.makeText(this@SignUoOneActivity, "OTP Sending Failed: ${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }


  fun navigateToOTPActivity(){
    val destIntent = SignUoTwoActivity.getIntent(this, null)
    destIntent.putExtra("otp",otp)
    destIntent.putExtra("mobile_number",mobileNumber)
    destIntent.putExtra("referral_code",referralCode)
    startActivity(destIntent)
    finish()
  }
  companion object {
    const val TAG: String = "SIGN_UO_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
