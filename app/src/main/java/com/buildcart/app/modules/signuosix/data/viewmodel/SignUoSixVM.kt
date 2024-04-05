package com.buildcart.app.modules.signuosix.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuosix.`data`.model.SignUoSixModel
import org.koin.core.KoinComponent

class SignUoSixVM : ViewModel(), KoinComponent {
  val signUoSixModel: MutableLiveData<SignUoSixModel> = MutableLiveData(SignUoSixModel())

  var navArguments: Bundle? = null
}
