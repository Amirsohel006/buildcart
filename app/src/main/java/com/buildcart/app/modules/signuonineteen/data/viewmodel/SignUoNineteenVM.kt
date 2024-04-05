package com.buildcart.app.modules.signuonineteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuonineteen.`data`.model.SignUoNineteenModel
import org.koin.core.KoinComponent

class SignUoNineteenVM : ViewModel(), KoinComponent {
  val signUoNineteenModel: MutableLiveData<SignUoNineteenModel> =
      MutableLiveData(SignUoNineteenModel())

  var navArguments: Bundle? = null
}
