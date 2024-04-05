package com.buildcart.app.modules.frame309.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrame309Binding
import com.buildcart.app.modules.frame309.`data`.viewmodel.Frame309VM
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import kotlin.String
import kotlin.Unit

class Frame309Activity : BaseActivity<ActivityFrame309Binding>(R.layout.activity_frame_309) {
  private val viewModel: Frame309VM by viewModels<Frame309VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame309VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGoToHome.setOnClickListener {
      val destIntent = HomeOneContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME309ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame309Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
