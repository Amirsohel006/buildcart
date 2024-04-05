package com.buildcart.app.modules.frame314.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityFrame314Binding
import com.buildcart.app.modules.frame314.`data`.viewmodel.Frame314VM
import com.buildcart.app.modules.home.ui.HomeActivity
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import com.buildcart.app.modules.signuoone.ui.SignUoOneActivity
import com.buildcart.app.modules.signuosix.ui.SignUoSixActivity
import kotlin.String
import kotlin.Unit

class Frame314Activity : BaseActivity<ActivityFrame314Binding>(R.layout.activity_frame_314) {
  private val viewModel: Frame314VM by viewModels<Frame314VM>()
  private lateinit var  sessionManager:SessionManager

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame314VM = viewModel

    sessionManager= SessionManager(this)

    if (sessionManager.fetchAuthToken() != null && sessionManager.fetchRefreshToken() != null) {
      // User is already logged in, navigate to home
      navigateToHomeActivity()
      finish() // Finish the current activity to prevent the user from going back to the login screen
    }


    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }

  override fun setUpClicks(): Unit {
    binding.btnDoLater.setOnClickListener {
      val destIntent = HomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnSignup.setOnClickListener {
      val destIntent = SignUoOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnLogin.setOnClickListener {
      val destIntent = SignUoSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }


  override fun onResume() {
    super.onResume()
    makeStatusBarTransparent()
  }

  private fun makeStatusBarTransparent() {
    window.decorView.systemUiVisibility =
      View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      window.statusBarColor = getColor(android.R.color.transparent)
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
  }

  companion object {
    const val TAG: String = "FRAME314ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame314Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }


  fun navigateToHomeActivity(){
    val destIntent = HomeOneContainerActivity.getIntent(this, null)
    startActivity(destIntent)
    finish()
  }
}
