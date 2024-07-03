package com.buildcart.app.modules.signuo.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.BuyAllProductsRequest
import com.buildcart.app.databinding.ActivitySignUoBinding
import com.buildcart.app.modules.frame307.ui.Frame307Activity
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import com.buildcart.app.modules.responses.CompltedOrderResponse
import com.buildcart.app.modules.signuo.`data`.model.SignUoRowModel
import com.buildcart.app.modules.signuo.`data`.viewmodel.SignUoVM
import com.buildcart.app.modules.signuofour.ui.SignUoFourActivity
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SignUoActivity : BaseActivity<ActivitySignUoBinding>(R.layout.activity_sign_uo) {
  private val viewModel: SignUoVM by viewModels<SignUoVM>()

  private lateinit var sessionManager:SessionManager
  override fun onInitialized(): Unit {
    sessionManager=SessionManager(this)
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    var id=intent.getIntExtra("id",-1)


    binding.btnPay17630.setOnClickListener {
      //  val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
        val selectedText = "cod"
       // Toast.makeText(this, "Selected Payment Method: $selectedText", Toast.LENGTH_SHORT).show()
        buyproducts(id.toString(), selectedText) // Replace "address_id_here" with the actual address ID
        binding.progressBar.visibility=View.VISIBLE

    }


    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

    binding.signUoVM = viewModel
  }

  override fun setUpClicks(): Unit {
//    binding.linearRowcodcashond.setOnClickListener {
//      val destIntent = SignUoFourActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
//    binding.btnPay17630.setOnClickListener {
////      val destIntent = Frame307Activity.getIntent(this, null)
////      startActivity(destIntent)
//
//      Toast.makeText(this,"Need To Implement Payment Gateway",Toast.LENGTH_LONG).show()
//
//    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerSignUo(
    view: View,
    position: Int,
    item: SignUoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  private fun buyproducts(id1:String,mode1:String){

    val serviceGenerator= APIManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Bearer $accessToken"
    val id=id1
    val mode=mode1

    val request = BuyAllProductsRequest(
      shipping_address_id = id,
      mode_of_payment = mode
    )
    val call=serviceGenerator.buyallproducts(authorization,request)

    call.enqueue(object : retrofit2.Callback<CompltedOrderResponse>{
      @SuppressLint("SetTextI18n")
      override fun onResponse(
        call: Call<CompltedOrderResponse>,
        response: Response<CompltedOrderResponse>
      ) {
        binding.progressBar.visibility=View.GONE
        val customerResponse=response.body()

        if(customerResponse!=null){
          val dialogBinding =
            LayoutInflater.from(this@SignUoActivity).inflate(R.layout.row_to_cart, null)
          val myDialoge = Dialog(this@SignUoActivity)
          myDialoge.setContentView(dialogBinding)

          val img = dialogBinding.findViewById<ImageView>(R.id.imageComponentlott)
          val img1 = dialogBinding.findViewById<ImageView>(R.id.imageHttpslottief)

          // val btnGOCart=dialogBinding.findViewById<AppCompatButton>(R.id.btnCart)

          Glide.with(this@SignUoActivity).load(R.drawable.done).into(img)
          Glide.with(this@SignUoActivity).load(R.drawable.celebration).into(img1)
//                  btnGOCart.setOnClickListener{
//                    // This code will run after 3 seconds
//                    moveToCartFragment()
//
//                  }
          myDialoge.setCancelable(true)
          myDialoge.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
          myDialoge.show()


          Handler().postDelayed({
            myDialoge.dismiss() // Dismiss the dialog
            moveToHomeContainer() // Move to the home container
          }, 3000)
        }


      }
      override fun onFailure(call: Call<CompltedOrderResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
        binding.progressBar.visibility=View.GONE
      }
    })
  }


  private fun moveToHomeContainer(){
    val i=Intent(this,HomeOneContainerActivity::class.java)
    startActivity(i)
  }
  companion object {
    const val TAG: String = "SIGN_UO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
