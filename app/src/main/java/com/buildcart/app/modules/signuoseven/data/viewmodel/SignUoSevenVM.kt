package com.buildcart.app.modules.signuoseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoseven.`data`.model.SignUoSevenModel
import org.koin.core.KoinComponent

class SignUoSevenVM : ViewModel(), KoinComponent {
  val signUoSevenModel: MutableLiveData<SignUoSevenModel> = MutableLiveData(SignUoSevenModel())

  var navArguments: Bundle? = null
}
