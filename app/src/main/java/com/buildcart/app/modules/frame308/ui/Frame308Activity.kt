package com.buildcart.app.modules.frame308.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrame308Binding
import com.buildcart.app.modules.frame308.`data`.viewmodel.Frame308VM
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import kotlin.String
import kotlin.Unit

class Frame308Activity : BaseActivity<ActivityFrame308Binding>(R.layout.activity_frame_308) {
  private val viewModel: Frame308VM by viewModels<Frame308VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame308VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGoToHome.setOnClickListener {
      val destIntent = HomeOneContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME308ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame308Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
