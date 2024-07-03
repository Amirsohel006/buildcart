package com.buildcart.app.modules.product.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.ProductDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityProductBinding
import com.buildcart.app.modules.homeone.data.model.ProductDetailsDataResponse
import com.buildcart.app.modules.homeone.data.model.ProductdescriptionResponse
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity
import com.buildcart.app.modules.mycart.data.model.CartProduct
import com.buildcart.app.modules.mycart.ui.CartNewAdapter
import com.buildcart.app.modules.orders.data.model.OrderStatusRequest
import com.buildcart.app.modules.orders.ui.ActiveOrderAdapter
import com.buildcart.app.modules.product.`data`.model.ImageSliderSliderrectangle105Model
import com.buildcart.app.modules.product.`data`.model.Listrectangle105FourRowModel
import com.buildcart.app.modules.product.`data`.model.Listrectangle105OneRowModel
import com.buildcart.app.modules.product.`data`.model.SpinnerGroupThirtyTwoModel
import com.buildcart.app.modules.product.`data`.viewmodel.ProductVM
import com.buildcart.app.modules.responses.CategoriesResponse
import com.buildcart.app.modules.responses.ProductDescriptionResponses
import com.buildcart.app.modules.signuofive.ui.SignUoFiveActivity
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class ProductActivity : BaseActivity<ActivityProductBinding>(R.layout.activity_product) {

  private lateinit var image:String
  private lateinit var   imageUri: Uri

  var file:String=""

  var productId:String=""


  private val imageSliderSliderrectangle105Items: MutableList<ImageSliderSliderrectangle105Model> = mutableListOf()



  private val viewModel: ProductVM by viewModels<ProductVM>()


  private lateinit var sessionManager:SessionManager
  private lateinit var handler: Handler
  private lateinit var runnable: Runnable
  private var currentPage = 0



  override fun onInitialized(): Unit {

    viewModel.navArguments = intent.extras?.getBundle("bundle")


    sessionManager= SessionManager(this)


    image=file



    val listrectangle105FourAdapter =
    Listrectangle105FourAdapter(viewModel.listrectangle105FourList.value?:mutableListOf())


    viewModel.listrectangle105FourList.observe(this) {
      listrectangle105FourAdapter.updateData(it)
    }


     productId = intent.getStringExtra("productId")!!


    getMyStudioRequests(productId)

    binding.progressBar.visibility=View.VISIBLE
    binding.productVM = viewModel


    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
    handler = Handler(Looper.getMainLooper())
    runnable = object : Runnable {
      override fun run() {
        if (imageSliderSliderrectangle105Items.isNotEmpty()) {
          currentPage = (currentPage + 1) % imageSliderSliderrectangle105Items.size
          binding.imageSliderSliderrectangle105.setCurrentItem(currentPage, true)
          handler.postDelayed(this, 2000) // Slide every 2 seconds
        }
      }
    }

  }


  private fun getMyStudioRequests(productId:String){

    val serviceGenerator= APIManager.apiInterface
    val accessToken=sessionManager.fetchAuthToken()
    val authorization="Bearer $accessToken"
    val call=serviceGenerator.getProductWithDescription(authorization,productId)

    call.enqueue(object : retrofit2.Callback<ProductdescriptionResponse>{
      @SuppressLint("SetTextI18n")
      override fun onResponse(
        call: Call<ProductdescriptionResponse>,
        response: Response<ProductdescriptionResponse>
      ) {
        binding.progressBar.visibility=View.GONE
        val customerResponse=response.body()

        if((customerResponse!=null)&&(customerResponse.success=="true")){
          val details=customerResponse.response


          binding.txtDescription.text=details[0].description

          binding.txtDesignTiles.text=details[0].name

          binding.txtPrice.text=details[0].sellingPrice.toString()


          val imageUrls = details[0].productGalleries.map { it.image }

          Log.d("imageURLSOfAll",imageUrls.toString())
          updateImageSliderItems(imageUrls)
        }
      }



      override fun onFailure(call: Call<ProductdescriptionResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
        binding.progressBar.visibility=View.GONE
      }
    })
  }


  private fun updateImageSliderItems(imageUrls: List<String?>) {
    imageSliderSliderrectangle105Items.clear()
    imageUrls.forEach { imageUrl ->
      val fullImageUrl = APIManager.getImageUrl(imageUrl!!)

      imageSliderSliderrectangle105Items.add(ImageSliderSliderrectangle105Model(imageRectangle105 = fullImageUrl))
    }
    setupImageSlider()
  }

  private fun setupImageSlider() {
    val adapter = ViewPagerAdapter(this,imageSliderSliderrectangle105Items)
    binding.imageSliderSliderrectangle105.adapter = adapter
    handler.post(runnable)
  }



  private fun addtocart(poductID:String,quantity:String) {
    val serviceGenerator = APIManager.apiInterface
    val accessToken = sessionManager.fetchAuthToken()
    val authorization = "Bearer $accessToken"
    val call = serviceGenerator.addtocart(authorization,poductID,quantity)



    call.enqueue(object : retrofit2.Callback<ProductDescriptionResponses> {
      @SuppressLint("MissingInflatedId")
      override fun onResponse(call: Call<ProductDescriptionResponses>, response: Response<ProductDescriptionResponses>) {
        binding.progressBar.visibility=View.GONE
        if (response.isSuccessful) {
          val customerResponse=response.body()
          //Toast.makeText(, "Add to cart Successfull", Toast.LENGTH_SHORT).show()
          // Handle a successful API response here, if needed

          if((customerResponse!=null)&&(customerResponse.success=="true")) {

            val dialogBinding =
              LayoutInflater.from(this@ProductActivity).inflate(R.layout.row_to_cart, null)
            val myDialoge = Dialog(this@ProductActivity)
            myDialoge.setContentView(dialogBinding)

            val img = dialogBinding.findViewById<ImageView>(R.id.imageComponentlott)
            val img1 = dialogBinding.findViewById<ImageView>(R.id.imageHttpslottief)

            val btnGOCart=dialogBinding.findViewById<AppCompatButton>(R.id.btnCart)

            Glide.with(this@ProductActivity).load(R.drawable.done).into(img)
            Glide.with(this@ProductActivity).load(R.drawable.celebration).into(img1)
                  btnGOCart.setOnClickListener{
                    // This code will run after 3 seconds
                    movetoContainer()

                  }
            myDialoge.setCancelable(true)
            myDialoge.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialoge.show()
          }

        } else {

          binding.progressBar.visibility=View.GONE
        }
      }

      override fun onFailure(call: Call<ProductDescriptionResponses>, t: Throwable) {
        t.printStackTrace()
        binding.progressBar.visibility=View.GONE
      }
    })

  }


  fun movetoContainer(){
    val i=Intent(this,HomeOneContainerActivity::class.java)
    startActivity(i)
    finish()
  }



  override fun setUpClicks(): Unit {

    binding.imageArrowleft.setOnClickListener {
      finish()
    }


    binding.linearRowaddtocart.setOnClickListener {
      val quantity = binding.txtGroup452.text.toString().toIntOrNull() ?: 0 // Convert to Int, default to 0 if conversion fails

      if (quantity < 1) {
        Toast.makeText(this, "Please select at least 1 quantity", Toast.LENGTH_SHORT).show()
      } else {
        addtocart(productId, quantity.toString())
        binding.progressBar.visibility = View.VISIBLE
      }
    }



    binding.linearRowlanguage.setOnClickListener {

      val quantity = binding.txtGroup452.text.toString().toIntOrNull() ?: 0

      if (quantity < 1) {
        Toast.makeText(this, "Please select at least 1 quantity", Toast.LENGTH_SHORT).show()
      } else {
        val destIntent = SignUoFiveActivity.getIntent(this, null)
        startActivity(destIntent)
      }


    }

  }

  fun onClickRecyclerListrectangle105One(
    view: View,
    position: Int,
    item: Listrectangle105OneRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListrectangle105Four(
    view: View,
    position: Int,
    item: Listrectangle105FourRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PRODUCT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProductActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
