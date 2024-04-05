package com.buildcart.app.modules.homeonecontainer.`data`.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.frame311.ui.Frame311Activity
import com.buildcart.app.modules.homeonecontainer.`data`.model.HomeOneContainerModel
import org.koin.core.KoinComponent

class HomeOneContainerVM : ViewModel(), KoinComponent {
  val homeOneContainerModel: MutableLiveData<HomeOneContainerModel> =
      MutableLiveData(HomeOneContainerModel())

  var navArguments: Bundle? = null


    fun onImageVectorClick(context: Context) {
        // Handle click event, e.g., open Frame311Activity as drawer
        // You may want to use Intent to navigate to Frame311Activity or handle it based on your navigation logic

        // If using Intent:
        val intent = Intent(context, Frame311Activity::class.java)
        context.startActivity(intent)

        // Implement additional logic to open it as a drawer
        // You might want to use the navArguments Bundle here if needed
    }

}
