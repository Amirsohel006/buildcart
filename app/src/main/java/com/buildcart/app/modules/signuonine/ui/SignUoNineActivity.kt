package com.buildcart.app.modules.signuonine.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoNineBinding
import com.buildcart.app.modules.ordersfour.ui.OrdersFourActivity
import com.buildcart.app.modules.signuonine.`data`.viewmodel.SignUoNineVM
import kotlin.String
import kotlin.Unit

class SignUoNineActivity : BaseActivity<ActivitySignUoNineBinding>(R.layout.activity_sign_uo_nine) {
  private val viewModel: SignUoNineVM by viewModels<SignUoNineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoNineVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowfloatingicon.setOnClickListener {
      val destIntent = OrdersFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_NINE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoNineActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
