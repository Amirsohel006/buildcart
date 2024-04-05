package com.buildcart.app.modules.signuoeleven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoeleven.`data`.model.SignUoElevenModel
import org.koin.core.KoinComponent

class SignUoElevenVM : ViewModel(), KoinComponent {
  val signUoElevenModel: MutableLiveData<SignUoElevenModel> = MutableLiveData(SignUoElevenModel())

  var navArguments: Bundle? = null
}
