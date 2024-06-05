package com.buildcart.app.modules.product.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.ProductDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityProductBinding
import com.buildcart.app.modules.homeone.data.model.ProductDetailsDataResponse
import com.buildcart.app.modules.homeone.data.model.ProductdescriptionResponse
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
 // private val imageUri: Uri = Uri.parse("android.resource://com.buildcart.app/drawable/img_image5")


//  private val imageSliderSliderrectangle105Items: ArrayList<ImageSliderSliderrectangle105Model> =
//      arrayListOf(ImageSliderSliderrectangle105Model(imageRectangle105 =
//  imageUri.toString()),ImageSliderSliderrectangle105Model(imageRectangle105 =
//  imageUri.toString()))


  private val imageSliderSliderrectangle105Items: ArrayList<ImageSliderSliderrectangle105Model> by lazy {
    // Initialize imageUri after assigning a value to the image property
    imageUri = Uri.parse(image)

    // Initialize the list using the initialized imageUri
    arrayListOf(
      ImageSliderSliderrectangle105Model(imageRectangle105 = imageUri.toString()),
      ImageSliderSliderrectangle105Model(imageRectangle105 = imageUri.toString())
    )
  }


  private val viewModel: ProductVM by viewModels<ProductVM>()


  private lateinit var sessionManager:SessionManager

  override fun onInitialized(): Unit {

    viewModel.navArguments = intent.extras?.getBundle("bundle")


    sessionManager= SessionManager(this)


    image=file

    Log.e("System Image",image.toString())
    binding.indicatorGroup117.updateIndicatorCounts(binding.imageSliderSliderrectangle105.indicatorCount)
    val listrectangle105OneAdapter =
    Listrectangle105OneAdapter(viewModel.listrectangle105OneList.value?:mutableListOf())



    val sliderrectanglefiftysixAdapter =
      Sliderrectangle105Adapter(imageSliderSliderrectangle105Items,true)
    binding.imageSliderSliderrectangle105.adapter = sliderrectanglefiftysixAdapter
    binding.imageSliderSliderrectangle105.onIndicatorProgress = { selectingPosition,
                                                                       progress ->
      binding.indicatorGroup117.onPageScrolled(selectingPosition, progress)
    }
//    binding.recyclerListrectangle105One.adapter = listrectangle105OneAdapter
//    listrectangle105OneAdapter.setOnItemClickListener(
//    object : Listrectangle105OneAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listrectangle105OneRowModel) {
//        onClickRecyclerListrectangle105One(view, position, item)
//      }
//    }
//    )

    viewModel.listrectangle105OneList.observe(this) {
      listrectangle105OneAdapter.updateData(it)
    }

    val listrectangle105FourAdapter =
    Listrectangle105FourAdapter(viewModel.listrectangle105FourList.value?:mutableListOf())
//    binding.recyclerListrectangle105Four.adapter = listrectangle105FourAdapter
//    listrectangle105FourAdapter.setOnItemClickListener(
//    object : Listrectangle105FourAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : Listrectangle105FourRowModel) {
//        onClickRecyclerListrectangle105Four(view, position, item)
//      }
//    }
//    )

    viewModel.listrectangle105FourList.observe(this) {
      listrectangle105FourAdapter.updateData(it)
    }


     productId = intent.getStringExtra("productId")!!


    getMyStudioRequests(productId)

    binding.progressBar.visibility=View.VISIBLE
    binding.productVM = viewModel


    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
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

          val imageUrl = details[0].productGalleries[0].image
            ?: throw NullPointerException("Image URL is null")
           file = APIManager.getImageUrl(imageUrl!!)


         // file=APIManager.getImageUrl(details[0].productGalleries[0].image!!)

         // image=file



         // productIdtoPass= details[0].productId.toString()




        }
      }



      override fun onFailure(call: Call<ProductdescriptionResponse>, t: Throwable) {
        t.printStackTrace()
        Log.e("error", t.message.toString())
        binding.progressBar.visibility=View.GONE
      }
    })
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

            // val btnGOCart=dialogBinding.findViewById<AppCompatButton>(R.id.btnCart)

            Glide.with(this@ProductActivity).load(R.drawable.done).into(img)
            Glide.with(this@ProductActivity).load(R.drawable.celebration).into(img1)
//                  btnGOCart.setOnClickListener{
//                    // This code will run after 3 seconds
//                    moveToCartFragment()
//
//                  }
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

  override fun onPause(): Unit {
    binding.imageSliderSliderrectangle105.pauseAutoScroll()
    super.onPause()
  }

  override fun onResume(): Unit {
    super.onResume()
    binding.imageSliderSliderrectangle105.resumeAutoScroll()
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
