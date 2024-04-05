package com.buildcart.app.modules.tile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityTileBinding
import com.buildcart.app.modules.product.ui.ProductActivity
import com.buildcart.app.modules.tile.`data`.model.TileRowModel
import com.buildcart.app.modules.tile.`data`.viewmodel.TileVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class TileActivity : BaseActivity<ActivityTileBinding>(R.layout.activity_tile) {
  private val viewModel: TileVM by viewModels<TileVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val tileAdapter = TileAdapter(viewModel.tileList.value?:mutableListOf())
    binding.recyclerTile.adapter = tileAdapter
    tileAdapter.setOnItemClickListener(
    object : TileAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : TileRowModel) {
        onClickRecyclerTile(view, position, item)
      }
    }
    )
    viewModel.tileList.observe(this) {
      tileAdapter.updateData(it)
    }
    binding.tileVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerTile(
    view: View,
    position: Int,
    item: TileRowModel
  ): Unit {
    when(view.id) {
      R.id.txtDesignTiles -> {
        onClickRecyclerTileTxtDesignTiles(view, position, item)
      }
      R.id.linearColumnrectangle105 -> {
        onClickRecyclerTileLinearColumnrectangle105(view, position, item)
      }
      R.id.imageRectangle105 -> {
        onClickRecyclerTileImageRectangle105(view, position, item)
      }
    }
  }

  fun onClickRecyclerTileTxtDesignTiles(
    view: View,
    position: Int,
    item: TileRowModel
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
    }
  }

  fun onClickRecyclerTileLinearColumnrectangle105(
    view: View,
    position: Int,
    item: TileRowModel
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
    }
  }

  fun onClickRecyclerTileImageRectangle105(
    view: View,
    position: Int,
    item: TileRowModel
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
    }
  }

  companion object {
    const val TAG: String = "TILE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, TileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
