package com.buildcart.app.modules.frametwentyseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frametwentyseven.`data`.model.FrameTwentysevenModel
import org.koin.core.KoinComponent

class FrameTwentysevenVM : ViewModel(), KoinComponent {
  val frameTwentysevenModel: MutableLiveData<FrameTwentysevenModel> =
      MutableLiveData(FrameTwentysevenModel())

  var navArguments: Bundle? = null
}
