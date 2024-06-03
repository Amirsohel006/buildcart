package com.buildcart.app.modules.ordersthree.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityOrdersThreeBinding
import com.buildcart.app.modules.ordersthree.`data`.viewmodel.OrdersThreeVM
import com.buildcart.app.modules.responses.AddressResponse
import com.buildcart.app.modules.signuofive.ui.SignUoFiveActivity
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class OrdersThreeActivity : BaseActivity<ActivityOrdersThreeBinding>(R.layout.activity_orders_three)
    {
  private val viewModel: OrdersThreeVM by viewModels<OrdersThreeVM>()

      private lateinit var sessionManager: SessionManager

private lateinit var placeForAddredd:String

private lateinit var checkBoxValue:String

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    sessionManager=SessionManager(this)


    val radioGroup = binding.rgRadiogrouphome
   val radioButton1 = binding.rbHome
    val radioButton2 = binding.rbHomeOne
   val  radioButton3 = binding.rbHomeTwo


    radioGroup.setOnCheckedChangeListener { group, checkedId ->
      val selectedRadioButton = findViewById<RadioButton>(checkedId)
      val selectedText = selectedRadioButton.text.toString()
      placeForAddredd=selectedText
    }

    binding.checkBoxSetasDefault.setOnCheckedChangeListener { _, isChecked ->
      val checkedState: Boolean = isChecked


      if (isChecked) {
        // Checkbox is checked
        checkBoxValue="True"
      } else {
        // Checkbox is unchecked
        checkBoxValue="False"
      }
    }



    binding.btnAdd.setOnClickListener {
      val name=binding.txtRahul.text.toString()
      val mobilenumber=binding.txtMobileNo.text.toString()
      val state=binding.etGroupNinetyOne11.text.toString()
      val city=binding.etGroupNinetyOne1.text.toString()
      val pincode=binding.etGroupNinetyOne112.text.toString()
      val flat=binding.etGroupNinetyTwo.text.toString()   //landmark
      val house_no=binding.etGroupNinetyOne.text.toString()
      val place=placeForAddredd
      val housename=binding.etGroupNinetyOne1121.text.toString()
      val area=binding.etGroupNinetyOne112111.text.toString()

      val setAsDefault=checkBoxValue

      val street=binding.etGroupNinetyOne11211.text.toString()
      postAddress(name,mobilenumber,place,house_no,city,state,pincode,flat,housename,area,street,setAsDefault)

    }
    binding.ordersThreeVM = viewModel
    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
  }


    private  fun handleCheckboxState(isChecked: Boolean) {
        // Handle the checkbox state here

      }
  override fun setUpClicks(): Unit {
    binding.btnAdd.setOnClickListener {
      val destIntent = SignUoFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }


      fun postAddress(
        name:String,
        mobile_number:String,
        city:String,
        state:String,
        postal_code:String,
        area:String,
        house_no:String,
        street:String,
        house_name:String,
        place:String,
        landmark:String,
        setasdefault: String
      ){
        val serviceGenerator = APIManager.apiInterface
        val accestoken = sessionManager.fetchAuthToken()
        val authorization = "Bearer $accestoken"
        val call = serviceGenerator.postAddress(authorization,name,mobile_number,area,house_no, city, state, postal_code,street,house_name, place,landmark,setasdefault)

        call.enqueue(object : retrofit2.Callback<AddressResponse>{
          override fun onResponse(
            call: Call<AddressResponse>,
            response: Response<AddressResponse>
          ) {
            if (response.isSuccessful) {
              // Toast.makeText(this@OrderConfirmationOneActivity,"Address Added Successfully Please go back!!",Toast.LENGTH_SHORT).show()


              val dialogBinding =
                LayoutInflater.from(this@OrdersThreeActivity).inflate(R.layout.row_to_cart, null)
              val myDialoge = Dialog(this@OrdersThreeActivity)
              myDialoge.setContentView(dialogBinding)

              val img=dialogBinding.findViewById<ImageView>(R.id.imageComponentlott)
              val img1=dialogBinding.findViewById<ImageView>(R.id.imageHttpslottief)

              // val btnGOCart=dialogBinding.findViewById<AppCompatButton>(R.id.btnCart)

              Glide.with(this@OrdersThreeActivity).load(R.drawable.done).into(img)
              Glide.with(this@OrdersThreeActivity).load(R.drawable.celebration).into(img1)
//                  btnGOCart.setOnClickListener{
//                    // This code will run after 3 seconds
//                    moveToCartFragment()
//
//                  }

              val btnGoHome=dialogBinding.findViewById<AppCompatButton>(R.id.btnCart)
              myDialoge.setCancelable(true)
              myDialoge.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
              myDialoge.show()

            }
          }

          override fun onFailure(call: Call<AddressResponse>, t: Throwable) {
            t.printStackTrace()
            Log.e("error", t.message.toString())
          }
        })
      }


      companion object {
    const val TAG: String = "ORDERS_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrdersThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
