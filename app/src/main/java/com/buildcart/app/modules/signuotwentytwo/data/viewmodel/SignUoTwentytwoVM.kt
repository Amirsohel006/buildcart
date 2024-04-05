package com.buildcart.app.modules.signuotwentytwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuotwentytwo.`data`.model.SignUoTwentytwoModel
import org.koin.core.KoinComponent

class SignUoTwentytwoVM : ViewModel(), KoinComponent {
  val signUoTwentytwoModel: MutableLiveData<SignUoTwentytwoModel> =
      MutableLiveData(SignUoTwentytwoModel())

  var navArguments: Bundle? = null
}
