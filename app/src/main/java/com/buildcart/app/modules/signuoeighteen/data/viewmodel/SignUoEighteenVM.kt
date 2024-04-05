package com.buildcart.app.modules.signuoeighteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoeighteen.`data`.model.SignUoEighteenModel
import org.koin.core.KoinComponent

class SignUoEighteenVM : ViewModel(), KoinComponent {
  val signUoEighteenModel: MutableLiveData<SignUoEighteenModel> =
      MutableLiveData(SignUoEighteenModel())

  var navArguments: Bundle? = null
}
