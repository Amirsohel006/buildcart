package com.buildcart.app.modules.signuotwo.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.buildcart.app.data.response.RequestSignUpResponse
import com.buildcart.app.databinding.ActivitySignUoTwoBinding
import com.buildcart.app.modules.signuoeleven.ui.SignUoElevenActivity
import com.buildcart.app.modules.signuotwo.`data`.viewmodel.SignUoTwoVM
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

class SignUoTwoActivity : BaseActivity<ActivitySignUoTwoBinding>(R.layout.activity_sign_uo_two) {
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


  val getActivityResult: ActivityResultLauncher<Intent> =
      registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
  ActivityResultCallback {
    val message = it.data?.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
    getOtpFromMessage(message!!)
    })


    private val viewModel: SignUoTwoVM by viewModels<SignUoTwoVM>()

    override fun onInitialized(): Unit {
      viewModel.navArguments = intent.extras?.getBundle("bundle")
      startSmartUserConsent()
      binding.signUoTwoVM = viewModel

      mobileNumber=intent.getStringExtra("mobile_number").toString()
      otp=intent.getStringExtra("otp").toString()

      binding.txtLanguage.text=mobileNumber
      otpEditText1=findViewById(R.id.viewOTP1)
      otpEditText2=findViewById(R.id.viewOTP2)
      otpEditText3=findViewById(R.id.viewOTP3)
      otpEditText4=findViewById(R.id.viewOTP4)
      otpEditText5=findViewById(R.id.viewOTP5)
      otpEditText6=findViewById(R.id.viewOTP6)



      setupOtpEditTextListeners()

      apiInterface = APIManager.apiInterface
      window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
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

        val enteredOTP = otpEditText1.text.toString() +
                otpEditText2.text.toString() +
                otpEditText3.text.toString() +
                otpEditText4.text.toString() +
                otpEditText5.text.toString() +
                otpEditText6.text.toString()
        if (enteredOTP.length == 6) {
          //login(enteredOTP)

          verifyOTP(mobileNumber,otp)
        }
        else {
          Toast.makeText(this,"Please Enter Correct OTP", Toast.LENGTH_SHORT).show()
        }

        binding.progressBar.visibility=View.VISIBLE
      }
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


  fun verifyOTP(mobileNumber: String?,otp:String?){
      val call=apiInterface.verifySignUpOTP(mobileNumber,otp)
      call.enqueue(object : Callback<RequestSignUpResponse> {
        override fun onResponse(call: Call<RequestSignUpResponse>, response: Response<RequestSignUpResponse>) {
          if (response.isSuccessful) {
            binding.progressBar.visibility=View.GONE
            val loginResponse = response.body()
            if (loginResponse != null) {
              Toast.makeText(this@SignUoTwoActivity, "Otp Verified Successfully", Toast.LENGTH_LONG).show()
              navigateToSignUpFormActivity()
            } else {
              Toast.makeText(this@SignUoTwoActivity, "OTP Verification failed", Toast.LENGTH_SHORT).show()
              binding.progressBar.visibility=View.GONE
            }
          } else {
            Toast.makeText(this@SignUoTwoActivity, "OTP Verification Failed", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
          }
        }
        override fun onFailure(call: Call<RequestSignUpResponse>, t: Throwable) {
          Toast.makeText(this@SignUoTwoActivity, "OTP Verification Failed: ${t.message}", Toast.LENGTH_SHORT).show()
          binding.progressBar.visibility=View.GONE
        }
      })
    }


  fun navigateToSignUpFormActivity(){
    val destIntent = SignUoElevenActivity.getIntent(this, null)
    destIntent.putExtra("mobile_number",mobileNumber)
    startActivity(destIntent)
    finish()
  }











    companion object {
      const val TAG: String = "SIGN_UO_TWO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SignUoTwoActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
