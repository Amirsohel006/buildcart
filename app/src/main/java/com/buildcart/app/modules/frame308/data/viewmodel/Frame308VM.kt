package com.buildcart.app.modules.frame308.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frame308.`data`.model.Frame308Model
import org.koin.core.KoinComponent

class Frame308VM : ViewModel(), KoinComponent {
  val frame308Model: MutableLiveData<Frame308Model> = MutableLiveData(Frame308Model())

  var navArguments: Bundle? = null
}
