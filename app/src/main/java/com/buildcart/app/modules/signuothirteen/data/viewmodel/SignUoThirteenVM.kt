package com.buildcart.app.modules.signuothirteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuothirteen.`data`.model.SignUoThirteenModel
import org.koin.core.KoinComponent

class SignUoThirteenVM : ViewModel(), KoinComponent {
  val signUoThirteenModel: MutableLiveData<SignUoThirteenModel> =
      MutableLiveData(SignUoThirteenModel())

  var navArguments: Bundle? = null
}
