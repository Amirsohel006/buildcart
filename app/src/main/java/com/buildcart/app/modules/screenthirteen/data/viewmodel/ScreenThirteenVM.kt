package com.buildcart.app.modules.screenthirteen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.screenthirteen.`data`.model.ScreenThirteenModel
import org.koin.core.KoinComponent

class ScreenThirteenVM : ViewModel(), KoinComponent {
  val screenThirteenModel: MutableLiveData<ScreenThirteenModel> =
      MutableLiveData(ScreenThirteenModel())

  var navArguments: Bundle? = null
}
