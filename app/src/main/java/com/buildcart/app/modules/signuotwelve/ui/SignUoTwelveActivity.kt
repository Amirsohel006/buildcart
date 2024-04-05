package com.buildcart.app.modules.signuotwelve.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.LoginResponseData
import com.buildcart.app.data.response.RequestSignUpResponse
import com.buildcart.app.databinding.ActivitySignUoTwelveBinding
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import com.buildcart.app.modules.signuotwelve.`data`.viewmodel.SignUoTwelveVM
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import com.google.android.gms.auth.api.phone.SmsRetriever
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.String
import kotlin.Unit

class SignUoTwelveActivity :
    BaseActivity<ActivitySignUoTwelveBinding>(R.layout.activity_sign_uo_twelve) {
  private var otpViewOtpviewBroadcastReceiver: OtpViewOtpviewBroadcastReceiver? = null

  private lateinit var otpEditText1: EditText
  private lateinit var otpEditText2: EditText
  private lateinit var otpEditText3: EditText
  private lateinit var otpEditText4: EditText
  private lateinit var otpEditText5: EditText
  private lateinit var otpEditText6: EditText

  private lateinit var apiInterface: APIInterface
  private var mobileNumber:String=""
  private var otp:String=""

  private lateinit var sessionManager: SessionManager


  val getActivityResult: ActivityResultLauncher<Intent> =
      registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
  ActivityResultCallback {
    val message = it.data?.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
    getOtpFromMessage(message!!)
    })


    private val viewModel: SignUoTwelveVM by viewModels<SignUoTwelveVM>()

    override fun onInitialized(): Unit {
      viewModel.navArguments = intent.extras?.getBundle("bundle")
      startSmartUserConsent()
      binding.signUoTwelveVM = viewModel
      window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

      mobileNumber=intent.getStringExtra("mobile_number").toString()
      otp=intent.getStringExtra("otp").toString()

      binding.txtLanguage.text=mobileNumber
      Log.d("Mobile Number Login verify",mobileNumber)

      otpEditText1=findViewById(R.id.viewOTP1)
      otpEditText2=findViewById(R.id.viewOTP2)
      otpEditText3=findViewById(R.id.viewOTP3)
      otpEditText4=findViewById(R.id.viewOTP4)
      otpEditText5=findViewById(R.id.viewOTP5)
      otpEditText6=findViewById(R.id.viewOTP6)



      setupOtpEditTextListeners()
      apiInterface = APIManager.apiInterface
      sessionManager=SessionManager(this)

      if (sessionManager.fetchAuthToken() != null && sessionManager.fetchRefreshToken() != null) {
        // User is already logged in, navigate to home
        navigateToHomeActivity()
        finish() // Finish the current activity to prevent the user from going back to the login screen
      }

    }

  private fun setupOtpEditTextListeners() {
    otpEditText1.addTextChangedListener(OnOtpEditTextChangeListener(otpEditText2))
    otpEditText2.addTextChangedListener(OnOtpEditTextChangeListener(otpEditText3))
    otpEditText3.addTextChangedListener(OnOtpEditTextChangeListener(otpEditText4))
    otpEditText4.addTextChangedListener(OnOtpEditTextChangeListener(otpEditText5))
    otpEditText5.addTextChangedListener(OnOtpEditTextChangeListener(otpEditText6))
    otpEditText6.addTextChangedListener(OnOtpEditTextChangeListener(null))
  }


  private inner class OnOtpEditTextChangeListener(private val nextField: EditText?) :
    TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
      if (s?.length == 1 && nextField != null) {
        nextField.requestFocus()
      }
    }
  }


  fun verifyOTP(otp: String?){
    val call=apiInterface.verifyOTP(otp)
    call.enqueue(object : Callback<LoginResponseData> {
      override fun onResponse(call: Call<LoginResponseData>, response: Response<LoginResponseData>) {
        if (response.isSuccessful) {
          binding.progressBar.visibility=View.GONE
          val loginResponse = response.body()
          if (loginResponse != null) {
            Toast.makeText(this@SignUoTwelveActivity, "Otp Verified Successfully", Toast.LENGTH_LONG).show()

            sessionManager.saveAuthToken(loginResponse.accessToken.toString())
            sessionManager.saveRefreshToken(loginResponse.refreshToken.toString())

            Log.d("accessToken:",loginResponse.accessToken.toString())
            Log.d("refreshToken:",loginResponse.refreshToken.toString())

            navigateToHomeActivity()
          } else {
            Toast.makeText(this@SignUoTwelveActivity, "OTP Verification failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
          }
        } else {
          Toast.makeText(this@SignUoTwelveActivity, response.message(), Toast.LENGTH_SHORT).show()
          binding.progressBar.visibility=View.GONE
        }
      }
      override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
        Toast.makeText(this@SignUoTwelveActivity, "OTP Verification Failed: ${t.message}", Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility=View.GONE
      }
    })
  }

    override fun onStop(): Unit {
      super.onStop()
      unregisterReceiver(otpViewOtpviewBroadcastReceiver)
    }

    override fun onStart(): Unit {
      super.onStart()
      registerBroadcastReceiver()
    }

    override fun setUpClicks(): Unit {
      binding.btnVerify.setOnClickListener {
//        val destIntent = HomeOneContainerActivity.getIntent(this, null)
//        startActivity(destIntent)


        val enteredOTP = otpEditText1.text.toString() +
                otpEditText2.text.toString() +
                otpEditText3.text.toString() +
                otpEditText4.text.toString() +
                otpEditText5.text.toString() +
                otpEditText6.text.toString()
        if (enteredOTP.length == 6) {
          //login(enteredOTP)

          verifyOTP(otp)
        }
        else {
          Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
        }

        binding.progressBar.visibility=View.VISIBLE
      }
    }


  fun navigateToHomeActivity(){
    val destIntent = HomeOneContainerActivity.getIntent(this, null)
    startActivity(destIntent)
    finish()
  }

  private fun navigateToHomeFragment() {
//    val fragmentTransaction = supportFragmentManager.beginTransaction()
//    // Replace with the appropriate HomeFragment instantiation
//    val homeFragment = HomeOneFragment()
//    fragmentTransaction.replace(R.id.linear, homeFragment)
//    fragmentTransaction.commit()
  }

    private fun startSmartUserConsent(): Unit {
      val client = SmsRetriever.getClient(this)
      client.startSmsUserConsent(null)
    }

    private fun registerBroadcastReceiver(): Unit {
      otpViewOtpviewBroadcastReceiver = OtpViewOtpviewBroadcastReceiver()
      otpViewOtpviewBroadcastReceiver?.otpBroadcastReceiverListener =
      object : OtpViewOtpviewBroadcastReceiver.OtpBroadcastListener {
        override fun onSuccess(intent: Intent?) {
          getActivityResult.launch(intent)
        }
        override fun onFailure() {

        }
      }
      val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
      registerReceiver(otpViewOtpviewBroadcastReceiver, intentFilter)
    }

    private fun getOtpFromMessage(message: String): Unit {
      val otpPattern: Pattern = Pattern.compile("(|^)\\d{6}")
      val matcher: Matcher = otpPattern.matcher(message)
      if (matcher.find()) {
        //binding.otpViewOtpview?.setText(matcher.group(0))
      }
    }

    companion object {
      const val TAG: String = "SIGN_UO_TWELVE_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SignUoTwelveActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
