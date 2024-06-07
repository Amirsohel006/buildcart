package com.buildcart.app.modules.signuoseventeen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoSeventeenBinding
import com.buildcart.app.modules.signuo.ui.SignUoActivity
import com.buildcart.app.modules.signuoseventeen.`data`.viewmodel.SignUoSeventeenVM
import kotlin.String
import kotlin.Unit

class SignUoSeventeenActivity :
    BaseActivity<ActivitySignUoSeventeenBinding>(R.layout.activity_sign_uo_seventeen) {
  private val viewModel: SignUoSeventeenVM by viewModels<SignUoSeventeenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoSeventeenVM = viewModel


    val id=intent.getIntExtra("id",-1)


    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.btnChoosePayment.setOnClickListener {
      val destIntent = SignUoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_SEVENTEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoSeventeenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
