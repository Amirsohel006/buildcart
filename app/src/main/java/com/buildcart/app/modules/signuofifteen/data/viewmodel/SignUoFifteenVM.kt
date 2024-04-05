package com.buildcart.app.modules.signuofifteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuofifteen.`data`.model.SignUoFifteenModel
import org.koin.core.KoinComponent

class SignUoFifteenVM : ViewModel(), KoinComponent {
  val signUoFifteenModel: MutableLiveData<SignUoFifteenModel> =
      MutableLiveData(SignUoFifteenModel())

  var navArguments: Bundle? = null
}
