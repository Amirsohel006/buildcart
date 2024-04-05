package com.buildcart.app.modules.signuoseventeen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoseventeen.`data`.model.SignUoSeventeenModel
import org.koin.core.KoinComponent

class SignUoSeventeenVM : ViewModel(), KoinComponent {
  val signUoSeventeenModel: MutableLiveData<SignUoSeventeenModel> =
      MutableLiveData(SignUoSeventeenModel())

  var navArguments: Bundle? = null
}
