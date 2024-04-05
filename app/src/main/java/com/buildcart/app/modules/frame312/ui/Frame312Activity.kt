package com.buildcart.app.modules.frame312.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrame312Binding
import com.buildcart.app.modules.frame312.`data`.viewmodel.Frame312VM
import com.buildcart.app.modules.frame314.ui.Frame314Activity
import com.buildcart.app.modules.signuoone.ui.SignUoOneActivity
import kotlin.String
import kotlin.Unit

class Frame312Activity : BaseActivity<ActivityFrame312Binding>(R.layout.activity_frame_312) {
  private val viewModel: Frame312VM by viewModels<Frame312VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame312VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowvector.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowshare.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtSignupLogin.setOnClickListener {
      val destIntent = SignUoOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfoOne.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowquestion.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowinfo.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcart.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlocation.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowmenu.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME312ACTIVITY"

  }
}
