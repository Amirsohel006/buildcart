package com.buildcart.app.modules.signuo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoBinding
import com.buildcart.app.modules.frame307.ui.Frame307Activity
import com.buildcart.app.modules.signuo.`data`.model.SignUoRowModel
import com.buildcart.app.modules.signuo.`data`.viewmodel.SignUoVM
import com.buildcart.app.modules.signuofour.ui.SignUoFourActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SignUoActivity : BaseActivity<ActivitySignUoBinding>(R.layout.activity_sign_uo) {
  private val viewModel: SignUoVM by viewModels<SignUoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val signUoAdapter = SignUoAdapter(viewModel.signUoList.value?:mutableListOf())
    binding.recyclerSignUo.adapter = signUoAdapter
    signUoAdapter.setOnItemClickListener(
    object : SignUoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : SignUoRowModel) {
        onClickRecyclerSignUo(view, position, item)
      }
    }
    )
    viewModel.signUoList.observe(this) {
      signUoAdapter.updateData(it)
    }
    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

    binding.signUoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowcodcashond.setOnClickListener {
      val destIntent = SignUoFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPay17630.setOnClickListener {
//      val destIntent = Frame307Activity.getIntent(this, null)
//      startActivity(destIntent)

      Toast.makeText(this,"Need To Implement Payment Gateway",Toast.LENGTH_LONG).show()

    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerSignUo(
    view: View,
    position: Int,
    item: SignUoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
