package com.buildcart.app.modules.screenfourteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.screenfourteen.`data`.model.ScreenFourteenModel
import org.koin.core.KoinComponent

class ScreenFourteenVM : ViewModel(), KoinComponent {
  val screenFourteenModel: MutableLiveData<ScreenFourteenModel> =
      MutableLiveData(ScreenFourteenModel())

  var navArguments: Bundle? = null
}
