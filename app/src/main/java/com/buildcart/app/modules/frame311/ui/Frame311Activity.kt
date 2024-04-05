package com.buildcart.app.modules.frame311.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityFrame311Binding
import com.buildcart.app.modules.aboutus.AboutUsActivity
import com.buildcart.app.modules.fav.ui.FavActivity
import com.buildcart.app.modules.frame311.`data`.viewmodel.Frame311VM
import com.buildcart.app.modules.mycart.ui.MyCartFragment
import com.buildcart.app.modules.orders.ui.OrdersFragment
import com.buildcart.app.modules.orders.ui.OrdersSectionFragment
import com.buildcart.app.modules.ordersthree.ui.OrdersThreeActivity
import com.buildcart.app.modules.signuofifteen.ui.ProfileActivity
import com.buildcart.app.modules.signuofourteen.ui.SignUoFourteenActivity
import com.buildcart.app.modules.signuoseven.ui.SignUoSevenActivity
import com.buildcart.app.modules.signuothree.ui.SignUoThreeActivity
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class Frame311Activity : BaseActivity<ActivityFrame311Binding>(R.layout.activity_frame_311) {
  private val viewModel: Frame311VM by viewModels<Frame311VM>()
  private lateinit var sessionManager: SessionManager
  private lateinit var fullName:String
  private lateinit var mobileNumber:String
  private lateinit var emailId:String
  private lateinit var apiInterface: APIInterface

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame311VM = viewModel
    apiInterface = APIManager.apiInterface
    sessionManager= SessionManager(this)
    fullName=sessionManager.fetchUserFullName().toString()
    mobileNumber=sessionManager.fetchUserMobileNumber().toString()
    emailId=sessionManager.fetchUserEmail().toString()
    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)

    binding.txtRahul.text=fullName
    binding.txtMobileNo.text=mobileNumber
    binding.txtEmail.text=emailId

    getProfiledata()
  }

  override fun setUpClicks(): Unit {

    // Add click listener for linearRowMenuCart
    binding.linearRowMenuCart.setOnClickListener {
      // Replace the current fragment with MyCartFragment
      replaceFragment(MyCartFragment())
    }

    // Add click listener for linearRowMenuOrders
    binding.linearRowMenuOrders.setOnClickListener {
      // Replace the current fragment with OrdersSectionFragment
      replaceFragment(OrdersFragment())
    }





    binding.linearRowMenuShare.setOnClickListener {
      val destIntent = SignUoFourteenActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.linearRowMenuPrivacyPolicy.setOnClickListener {
      val destIntent = SignUoSevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowMenuFAQs.setOnClickListener {
      val destIntent = SignUoThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtRahul.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageEllipseThirtyTwo.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowMenuFavourites.setOnClickListener {
      val destIntent = FavActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.linearRowMenuAddress.setOnClickListener(){

      val destIntent=OrdersThreeActivity.getIntent(this,null)
      startActivity(destIntent)
    }

    binding.linearRowMenuAbout.setOnClickListener {
      val i=Intent(this,AboutUsActivity::class.java)
      startActivity(i)
    }
  }


  fun getProfiledata(){
    val accestoken=sessionManager.fetchAuthToken()

    val authorization = "Bearer $accestoken"
    val call=apiInterface.getProfileDetails(authorization)
    call.enqueue(object : Callback<ProfileDataResponse> {
      override fun onResponse(call: Call<ProfileDataResponse>, response: Response<ProfileDataResponse>) {
        if (response.isSuccessful) {

          val loginResponse = response.body()
          if (loginResponse != null) {
            Toast.makeText(this@Frame311Activity, "Profile Data Successfully Fetched", Toast.LENGTH_LONG).show()



            val file= APIManager.getImageUrl(loginResponse.response!!.photo.toString())
            //profile_picture= loginResponse.response!!.photo.toString()

            sessionManager.saveProfilePicture(file)


            binding.txtRahul.text=loginResponse.response!!.fullName!!
            binding.txtMobileNo.text=loginResponse.response!!.mobileNumber
            binding.txtEmail.text=loginResponse.response!!.email



            Picasso.get().load(file).transform(ProfileActivity.CircleCrop()).placeholder(R.drawable.default_profile_background).into(binding.imageEllipseThirtyTwo)



            //navigateToHomeActivity()
          } else {
            Toast.makeText(this@Frame311Activity, "Profile Data fetching failed", Toast.LENGTH_SHORT).show()
          }
        } else {
          Toast.makeText(this@Frame311Activity, "Profile Data fetching Failed", Toast.LENGTH_SHORT).show()
        }
      }
      override fun onFailure(call: Call<ProfileDataResponse>, t: Throwable) {
        Toast.makeText(this@Frame311Activity, "Profile Data fetching: ${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }

  companion object {
    const val TAG: String = "FRAME311ACTIVITY"

  }

  private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
    supportFragmentManager.beginTransaction()
      .replace(R.id.linearColumnellipsethirtytwo, fragment)
      .addToBackStack(null)
      .commit()
  }

}
