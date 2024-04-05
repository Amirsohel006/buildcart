package com.buildcart.app.modules.signuothree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivitySignUoThreeBinding
import com.buildcart.app.modules.FAQAdapter
import com.buildcart.app.modules.aboutus.AboutUsAdapter
import com.buildcart.app.modules.responses.AboutUsResponses
import com.buildcart.app.modules.responses.FaqResponses
import com.buildcart.app.modules.signuothree.`data`.viewmodel.SignUoThreeVM
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SignUoThreeActivity :
    BaseActivity<ActivitySignUoThreeBinding>(R.layout.activity_sign_uo_three) {
  private val viewModel: SignUoThreeVM by viewModels<SignUoThreeVM>()


  private lateinit var sessionManager: SessionManager
  private lateinit var  recyclerView: RecyclerView
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoThreeVM = viewModel

     recyclerView=binding.recyclerview
    sessionManager= SessionManager(this)
    recyclerView=findViewById(R.id.recyclerview)
    val serviceGenerator = APIManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Bearer $accessToken"
    val call = serviceGenerator.getFaqs(authorization)

    call.enqueue(object : retrofit2.Callback<FaqResponses> {
      override fun onResponse(
        call: Call<FaqResponses>,
        response: Response<FaqResponses>
      ) {
        if (response.isSuccessful) {
          val storedResponse=response.body()
          recyclerView.apply {
            layoutManager= LinearLayoutManager(this@SignUoThreeActivity)
            adapter= FAQAdapter(storedResponse!!.response!!.faqs)
          }
        }
      }

      override fun onFailure(call: Call<FaqResponses>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
