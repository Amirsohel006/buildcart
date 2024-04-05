package com.buildcart.app.modules.signuofive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuofive.`data`.model.SignUoFiveModel
import org.koin.core.KoinComponent

class SignUoFiveVM : ViewModel(), KoinComponent {
  val signUoFiveModel: MutableLiveData<SignUoFiveModel> = MutableLiveData(SignUoFiveModel())

  var navArguments: Bundle? = null
}
