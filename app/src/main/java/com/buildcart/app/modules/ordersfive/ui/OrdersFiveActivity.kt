package com.buildcart.app.modules.ordersfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersFiveBinding
import com.buildcart.app.modules.ordersfive.`data`.model.OrdersFiveRowModel
import com.buildcart.app.modules.ordersfive.`data`.viewmodel.OrdersFiveVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OrdersFiveActivity : BaseActivity<ActivityOrdersFiveBinding>(R.layout.activity_orders_five) {
  private val viewModel: OrdersFiveVM by viewModels<OrdersFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val ordersFiveAdapter = OrdersFiveAdapter(viewModel.ordersFiveList.value?:mutableListOf())
    binding.recyclerOrdersFive.adapter = ordersFiveAdapter
    ordersFiveAdapter.setOnItemClickListener(
    object : OrdersFiveAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : OrdersFiveRowModel) {
        onClickRecyclerOrdersFive(view, position, item)
      }
    }
    )
    viewModel.ordersFiveList.observe(this) {
      ordersFiveAdapter.updateData(it)
    }
    binding.ordersFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerOrdersFive(
    view: View,
    position: Int,
    item: OrdersFiveRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ORDERS_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrdersFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
