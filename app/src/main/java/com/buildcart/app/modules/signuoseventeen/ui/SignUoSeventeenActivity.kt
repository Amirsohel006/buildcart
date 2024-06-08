package com.buildcart.app.modules.signuoseventeen.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivitySignUoSeventeenBinding
import com.buildcart.app.modules.mycart.data.model.CartProduct
import com.buildcart.app.modules.mycart.ui.CartNewAdapter
import com.buildcart.app.modules.signuo.ui.SignUoActivity
import com.buildcart.app.modules.signuoseventeen.`data`.viewmodel.SignUoSeventeenVM
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import com.google.firebase.firestore.GeoPoint
import retrofit2.Call
import retrofit2.Response
import java.util.Locale
import kotlin.String
import kotlin.Unit

class SignUoSeventeenActivity :
    BaseActivity<ActivitySignUoSeventeenBinding>(R.layout.activity_sign_uo_seventeen) {
  private val viewModel: SignUoSeventeenVM by viewModels<SignUoSeventeenVM>()


  private lateinit var sessionManager:SessionManager

  private var id=0
  override fun onInitialized(): Unit {
    sessionManager= SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoSeventeenVM = viewModel


     id=intent.getIntExtra("id",-1)
    val customerName=intent.getStringExtra("CUSTOMER_NAME")
    val pincode=intent.getStringExtra("PINCODE")
    val state=intent.getStringExtra("STATE")
    val city=intent.getStringExtra("CITY")
    val area=intent.getStringExtra("AREA")
    val mobile_number=intent.getStringExtra("Mobile")
    binding.txtAshishB.text=customerName
    binding.txtMobileNo.text=mobile_number
    binding.txtLanguage.text=area

    val address = "$area, $city, $state, $pincode"




    val geoPoint = getLocationFromAddress(address)
    if (geoPoint != null) {
      val url = "https://static-maps.yandex.ru/1.x/?ll=${geoPoint.longitude},${geoPoint.latitude}&z=15&l=map&size=450,450"
      Glide.with(this).load(url).into(binding.imageMapsicleMap)
    }


    getMyStudioRequests()
    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }



  private fun getLocationFromAddress(strAddress: String): GeoPoint? {
    val geocoder = Geocoder(this, Locale.getDefault())
    val addressList = geocoder.getFromLocationName(strAddress, 1)
    if (addressList != null) {
      if (addressList.isNotEmpty()) {
        val location = addressList[0]
        return GeoPoint(location.latitude, location.longitude)
      }
    }
    return null
  }
  override fun setUpClicks(): Unit {
    binding.btnChoosePayment.setOnClickListener {
      val destIntent = SignUoActivity.getIntent(this, null)
      destIntent.putExtra("id",id)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }


  private fun getMyStudioRequests(){

    val serviceGenerator= APIManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Bearer $accessToken"
    val call=serviceGenerator.getallproducts(authorization)

    call.enqueue(object : retrofit2.Callback<CartProduct>{
      @SuppressLint("SetTextI18n")
      override fun onResponse(
        call: Call<CartProduct>,
        response: Response<CartProduct>
      ) {
        val customerResponse=response.body()

        if((customerResponse!=null)&&(customerResponse.success=="true")){
          val studioModel=customerResponse.response
          binding.recyclerview.apply {
            layoutManager=
              LinearLayoutManager(this@SignUoSeventeenActivity, LinearLayoutManager.VERTICAL,false)
            val adapter= CartNewAdapter(studioModel,sessionManager)
            binding.recyclerview.adapter=adapter
            binding.txtPriceOne.text=adapter.calculateTotalPrices().toString()
            binding.txtPriceThree.text=adapter.calculateTotalPrices().toString()
          }

        }
      }
      override fun onFailure(call: Call<CartProduct>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
      }
    })
  }
  companion object {
    const val TAG: String = "SIGN_UO_SEVENTEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoSeventeenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
