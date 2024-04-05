package com.buildcart.app.modules.signuoeighteen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoEighteenBinding
import com.buildcart.app.modules.frame310.ui.Frame310Activity
import com.buildcart.app.modules.signuoeight.ui.SignUoEightActivity
import com.buildcart.app.modules.signuoeighteen.`data`.viewmodel.SignUoEighteenVM
import kotlin.String
import kotlin.Unit

class SignUoEighteenActivity :
    BaseActivity<ActivitySignUoEighteenBinding>(R.layout.activity_sign_uo_eighteen) {
  private val viewModel: SignUoEighteenVM by viewModels<SignUoEighteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoEighteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowpaypalone.setOnClickListener {
      val destIntent = SignUoEightActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPlaceOrder.setOnClickListener {
      val destIntent = Frame310Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_EIGHTEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoEighteenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
