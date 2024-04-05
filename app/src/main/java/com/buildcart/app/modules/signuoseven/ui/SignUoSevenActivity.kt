package com.buildcart.app.modules.signuoseven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivitySignUoSevenBinding
import com.buildcart.app.modules.frame311.ui.PrivacyPolicyAdapter
import com.buildcart.app.modules.responses.PrivacyPolicy
import com.buildcart.app.modules.signuoseven.`data`.viewmodel.SignUoSevenVM
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SignUoSevenActivity :
    BaseActivity<ActivitySignUoSevenBinding>(R.layout.activity_sign_uo_seven) {
  private val viewModel: SignUoSevenVM by viewModels<SignUoSevenVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    sessionManager=SessionManager(this)

    val recyclerView=binding.recyclerview
    val serviceGenerator = APIManager.apiInterface
    val accesToken=sessionManager.fetchAuthToken()
    val authorization="Bearer $accesToken"
    val call = serviceGenerator.getPrivacyPolicy(authorization)

    call.enqueue(object : retrofit2.Callback<PrivacyPolicy> {
      override fun onResponse(
        call: Call<PrivacyPolicy>,
        response: Response<PrivacyPolicy>
      ) {
        if (response.isSuccessful) {
          recyclerView.apply {
            layoutManager= LinearLayoutManager(this@SignUoSevenActivity)
            adapter= PrivacyPolicyAdapter(response.body()!!.response)
          }
        }
      }

      override fun onFailure(call: Call<PrivacyPolicy>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })


    binding.signUoSevenVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_SEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoSevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
