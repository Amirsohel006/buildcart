package com.buildcart.app.modules.frame310.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrame310Binding
import com.buildcart.app.modules.frame310.`data`.viewmodel.Frame310VM
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import kotlin.String
import kotlin.Unit

class Frame310Activity : BaseActivity<ActivityFrame310Binding>(R.layout.activity_frame_310) {
  private val viewModel: Frame310VM by viewModels<Frame310VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame310VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGoToHome.setOnClickListener {
      val destIntent = HomeOneContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME310ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame310Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
