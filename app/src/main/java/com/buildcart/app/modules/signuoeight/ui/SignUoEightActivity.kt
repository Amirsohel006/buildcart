package com.buildcart.app.modules.signuoeight.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoEightBinding
import com.buildcart.app.modules.frame309.ui.Frame309Activity
import com.buildcart.app.modules.signuoeight.`data`.model.SignUoEightRowModel
import com.buildcart.app.modules.signuoeight.`data`.viewmodel.SignUoEightVM
import com.buildcart.app.modules.signuoeighteen.ui.SignUoEighteenActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SignUoEightActivity :
    BaseActivity<ActivitySignUoEightBinding>(R.layout.activity_sign_uo_eight) {
  private val viewModel: SignUoEightVM by viewModels<SignUoEightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val signUoEightAdapter =
    SignUoEightAdapter(viewModel.signUoEightList.value?:mutableListOf())
    binding.recyclerSignUoEight.adapter = signUoEightAdapter
    signUoEightAdapter.setOnItemClickListener(
    object : SignUoEightAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : SignUoEightRowModel) {
        onClickRecyclerSignUoEight(view, position, item)
      }
    }
    )
    viewModel.signUoEightList.observe(this) {
      signUoEightAdapter.updateData(it)
    }
    binding.signUoEightVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPay17630.setOnClickListener {
      val destIntent = Frame309Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcodcashond.setOnClickListener {
      val destIntent = SignUoEighteenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerSignUoEight(
    view: View,
    position: Int,
    item: SignUoEightRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_EIGHT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoEightActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
