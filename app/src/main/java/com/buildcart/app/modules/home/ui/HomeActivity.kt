package com.buildcart.app.modules.home.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityHomeBinding
import com.buildcart.app.modules.frame314.ui.Frame314Activity
import com.buildcart.app.modules.home.`data`.model.HomeRowModel
import com.buildcart.app.modules.home.`data`.model.SpinnerGroup122Model
import com.buildcart.app.modules.home.`data`.viewmodel.HomeVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
  private val viewModel: HomeVM by viewModels<HomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerGroup122List.value = mutableListOf(
    SpinnerGroup122Model("Item1"),
    SpinnerGroup122Model("Item2"),
    SpinnerGroup122Model("Item3"),
    SpinnerGroup122Model("Item4"),
    SpinnerGroup122Model("Item5")
    )
    val spinnerGroup122Adapter =
    SpinnerGroup122Adapter(this,R.layout.spinner_item,viewModel.spinnerGroup122List.value?:
    mutableListOf())
   // binding.spinnerGroup122.adapter = spinnerGroup122Adapter
    val homeAdapter = HomeAdapter(viewModel.homeList.value?:mutableListOf())
    binding.recyclerHome.adapter = homeAdapter
    homeAdapter.setOnItemClickListener(
    object : HomeAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : HomeRowModel) {
        onClickRecyclerHome(view, position, item)
      }
    }
    )
    viewModel.homeList.observe(this) {
      homeAdapter.updateData(it)
    }


    val recyclerView: RecyclerView = binding.recyclerView1
    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    recyclerView.adapter = CategoryAdapterForDummy()


    // Attach LinearSnapHelper
    val snapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(recyclerView)

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

    binding.homeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumncategories.setOnClickListener {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerHome(
    view: View,
    position: Int,
    item: HomeRowModel
  ): Unit {
    when(view.id) {
      R.id.linearColumnrectangle105 -> {
        onClickRecyclerHomeLinearColumnrectangle105(view, position, item)
      }
    }
  }

  fun onClickRecyclerHomeLinearColumnrectangle105(
    view: View,
    position: Int,
    item: HomeRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
      2 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
      3 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
      4 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
      5 -> {
        val destIntent = Frame314Activity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "HOME_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
