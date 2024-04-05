package com.buildcart.app.modules.frame310.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frame310.`data`.model.Frame310Model
import org.koin.core.KoinComponent

class Frame310VM : ViewModel(), KoinComponent {
  val frame310Model: MutableLiveData<Frame310Model> = MutableLiveData(Frame310Model())

  var navArguments: Bundle? = null
}
