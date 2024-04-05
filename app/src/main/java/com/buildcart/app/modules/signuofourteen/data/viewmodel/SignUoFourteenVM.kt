package com.buildcart.app.modules.signuofourteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuofourteen.`data`.model.SignUoFourteenModel
import org.koin.core.KoinComponent

class SignUoFourteenVM : ViewModel(), KoinComponent {
  val signUoFourteenModel: MutableLiveData<SignUoFourteenModel> =
      MutableLiveData(SignUoFourteenModel())

  var navArguments: Bundle? = null
}
