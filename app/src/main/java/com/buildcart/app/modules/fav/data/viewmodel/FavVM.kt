package com.buildcart.app.modules.fav.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.fav.`data`.model.FavModel
import com.buildcart.app.modules.fav.`data`.model.FavRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FavVM : ViewModel(), KoinComponent {
  val favModel: MutableLiveData<FavModel> = MutableLiveData(FavModel())

  var navArguments: Bundle? = null

  val favList: MutableLiveData<MutableList<FavRowModel>> = MutableLiveData(mutableListOf())
}
