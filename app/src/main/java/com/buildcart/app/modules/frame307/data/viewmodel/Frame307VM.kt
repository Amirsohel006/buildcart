package com.buildcart.app.modules.frame307.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frame307.`data`.model.Frame307Model
import org.koin.core.KoinComponent

class Frame307VM : ViewModel(), KoinComponent {
  val frame307Model: MutableLiveData<Frame307Model> = MutableLiveData(Frame307Model())

  var navArguments: Bundle? = null
}
