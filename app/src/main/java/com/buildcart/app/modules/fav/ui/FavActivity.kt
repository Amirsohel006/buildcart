package com.buildcart.app.modules.fav.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFavBinding
import com.buildcart.app.modules.fav.`data`.model.FavRowModel
import com.buildcart.app.modules.fav.`data`.viewmodel.FavVM
import com.buildcart.app.modules.product.ui.ProductActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FavActivity : BaseActivity<ActivityFavBinding>(R.layout.activity_fav) {
  private val viewModel: FavVM by viewModels<FavVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val favAdapter = FavAdapter(viewModel.favList.value?:mutableListOf())
    binding.recyclerFav.adapter = favAdapter
    favAdapter.setOnItemClickListener(
    object : FavAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : FavRowModel) {
        onClickRecyclerFav(view, position, item)
      }
    }
    )
    viewModel.favList.observe(this) {
      favAdapter.updateData(it)
    }
    binding.favVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerFav(
    view: View,
    position: Int,
    item: FavRowModel
  ): Unit {
    when(view.id) {
      R.id.imageRectangle105 -> {
        onClickRecyclerFavImageRectangle105(view, position, item)
      }
      R.id.txtDesignTiles -> {
        onClickRecyclerFavTxtDesignTiles(view, position, item)
      }
      R.id.linearColumnrectangle105 -> {
        onClickRecyclerFavLinearColumnrectangle105(view, position, item)
      }
    }
  }

  fun onClickRecyclerFavImageRectangle105(
    view: View,
    position: Int,
    item: FavRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      2 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      3 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  fun onClickRecyclerFavTxtDesignTiles(
    view: View,
    position: Int,
    item: FavRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      2 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      3 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  fun onClickRecyclerFavLinearColumnrectangle105(
    view: View,
    position: Int,
    item: FavRowModel
  ): Unit {
    /** TODO As per your logic, Add constant type for item click.*/
    when(0) {
      0 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      1 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      2 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      3 -> {
        val destIntent = ProductActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "FAV_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FavActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
