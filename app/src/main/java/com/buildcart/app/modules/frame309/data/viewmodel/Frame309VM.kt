package com.buildcart.app.modules.frame309.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frame309.`data`.model.Frame309Model
import org.koin.core.KoinComponent

class Frame309VM : ViewModel(), KoinComponent {
  val frame309Model: MutableLiveData<Frame309Model> = MutableLiveData(Frame309Model())

  var navArguments: Bundle? = null
}
