package com.buildcart.app.modules.signuosixteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuosixteen.`data`.model.SignUoSixteenModel
import org.koin.core.KoinComponent

class SignUoSixteenVM : ViewModel(), KoinComponent {
  val signUoSixteenModel: MutableLiveData<SignUoSixteenModel> =
      MutableLiveData(SignUoSixteenModel())

  var navArguments: Bundle? = null
}
