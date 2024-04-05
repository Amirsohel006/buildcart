package com.buildcart.app.modules.tile.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.tile.`data`.model.TileModel
import com.buildcart.app.modules.tile.`data`.model.TileRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class TileVM : ViewModel(), KoinComponent {
  val tileModel: MutableLiveData<TileModel> = MutableLiveData(TileModel())

  var navArguments: Bundle? = null

  val tileList: MutableLiveData<MutableList<TileRowModel>> = MutableLiveData(mutableListOf())
}
