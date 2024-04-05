package com.buildcart.app.modules.signuo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuo.`data`.model.SignUoModel
import com.buildcart.app.modules.signuo.`data`.model.SignUoRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUoVM : ViewModel(), KoinComponent {
  val signUoModel: MutableLiveData<SignUoModel> = MutableLiveData(SignUoModel())

  var navArguments: Bundle? = null

  val signUoList: MutableLiveData<MutableList<SignUoRowModel>> = MutableLiveData(mutableListOf())
}
