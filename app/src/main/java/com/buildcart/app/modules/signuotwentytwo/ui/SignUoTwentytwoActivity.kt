package com.buildcart.app.modules.signuotwentytwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoTwentytwoBinding
import com.buildcart.app.modules.signuotwentytwo.`data`.viewmodel.SignUoTwentytwoVM
import kotlin.String
import kotlin.Unit

class SignUoTwentytwoActivity :
    BaseActivity<ActivitySignUoTwentytwoBinding>(R.layout.activity_sign_uo_twentytwo) {
  private val viewModel: SignUoTwentytwoVM by viewModels<SignUoTwentytwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoTwentytwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_TWENTYTWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoTwentytwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
