package com.buildcart.app.modules.frametwentyeight.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frametwentyeight.`data`.model.FrameTwentyeightModel
import org.koin.core.KoinComponent

class FrameTwentyeightVM : ViewModel(), KoinComponent {
  val frameTwentyeightModel: MutableLiveData<FrameTwentyeightModel> =
      MutableLiveData(FrameTwentyeightModel())

  var navArguments: Bundle? = null
}
