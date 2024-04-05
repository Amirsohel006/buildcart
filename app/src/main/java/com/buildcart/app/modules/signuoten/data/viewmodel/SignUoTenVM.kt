package com.buildcart.app.modules.signuoten.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoten.`data`.model.SignUoTenModel
import org.koin.core.KoinComponent

class SignUoTenVM : ViewModel(), KoinComponent {
  val signUoTenModel: MutableLiveData<SignUoTenModel> = MutableLiveData(SignUoTenModel())

  var navArguments: Bundle? = null
}
