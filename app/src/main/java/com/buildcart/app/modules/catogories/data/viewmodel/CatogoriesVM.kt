package com.buildcart.app.modules.catogories.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.catogories.`data`.model.CatogoriesModel
import com.buildcart.app.modules.catogories.`data`.model.CatogoriesRowModel
import com.buildcart.app.modules.catogories.`data`.model.SpinnerGroup122Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class CatogoriesVM : ViewModel(), KoinComponent {
  val catogoriesModel: MutableLiveData<CatogoriesModel> = MutableLiveData(CatogoriesModel())

  var navArguments: Bundle? = null

  val spinnerGroup122List: MutableLiveData<MutableList<SpinnerGroup122Model>> = MutableLiveData()

  val catogoriesList: MutableLiveData<MutableList<CatogoriesRowModel>> =
      MutableLiveData(mutableListOf())
}
