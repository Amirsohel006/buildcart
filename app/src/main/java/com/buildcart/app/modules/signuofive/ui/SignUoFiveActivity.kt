package com.buildcart.app.modules.signuofive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivitySignUoFiveBinding
import com.buildcart.app.modules.ordersthree.ui.OrdersThreeActivity
import com.buildcart.app.modules.responses.AddressResponse
import com.buildcart.app.modules.signuofive.`data`.viewmodel.SignUoFiveVM
import com.buildcart.app.modules.signuoseventeen.ui.SignUoSeventeenActivity
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class SignUoFiveActivity : BaseActivity<ActivitySignUoFiveBinding>(R.layout.activity_sign_uo_five) {
  private val viewModel: SignUoFiveVM by viewModels<SignUoFiveVM>()

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    sessionManager= SessionManager(this)


    binding.signUoFiveVM = viewModel

    val totalamount=intent.getStringExtra("total_amount")

    getAllAddresses()

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }



  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = SignUoSeventeenActivity.getIntent(this, null)
      val selectedPosition = (binding.recyclerview.adapter as AddressAdapter).getSelectedPosition()
      destIntent.putExtra("id",selectedPosition)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowfloatingicon.setOnClickListener {
      val destIntent = OrdersThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }



  fun getAllAddresses(){
    val recyclerView=binding.recyclerview
    val serviceGenerator = APIManager.apiInterface
    val accestoken = sessionManager.fetchAuthToken()
    val authorization = "Bearer $accestoken"
    val call = serviceGenerator.getAllAddresses(authorization)

    call.enqueue(object : retrofit2.Callback<List<AddressResponse>> {
      override fun onResponse(
        call: Call<List<AddressResponse>>,
        response: Response<List<AddressResponse>>
      ) {
       // binding.progressBar.visibility= View.GONE
        if (response.isSuccessful) {
          recyclerView.apply {

            layoutManager= LinearLayoutManager(this@SignUoFiveActivity, LinearLayoutManager.VERTICAL,false)
            val listAdapterForProducts =
              AddressAdapter(response.body()!!)
            binding.recyclerview.adapter = listAdapterForProducts
          }
        }
      }

      override fun onFailure(call: Call<List<AddressResponse>>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
        //binding.progressBar.visibility= View.GONE
      }
    })
  }



  companion object {
    const val TAG: String = "SIGN_UO_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
