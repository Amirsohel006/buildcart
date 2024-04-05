package com.buildcart.app.modules.signuonine.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuonine.`data`.model.SignUoNineModel
import org.koin.core.KoinComponent

class SignUoNineVM : ViewModel(), KoinComponent {
  val signUoNineModel: MutableLiveData<SignUoNineModel> = MutableLiveData(SignUoNineModel())

  var navArguments: Bundle? = null
}
