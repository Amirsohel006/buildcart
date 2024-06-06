package com.buildcart.app.modules.signuofourteen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoFourteenBinding
import com.buildcart.app.modules.signuofourteen.`data`.viewmodel.SignUoFourteenVM
import kotlin.String
import kotlin.Unit

class SignUoFourteenActivity :
    BaseActivity<ActivitySignUoFourteenBinding>(R.layout.activity_sign_uo_fourteen) {
  private val viewModel: SignUoFourteenVM by viewModels<SignUoFourteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoFourteenVM = viewModel

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_FOURTEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoFourteenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
