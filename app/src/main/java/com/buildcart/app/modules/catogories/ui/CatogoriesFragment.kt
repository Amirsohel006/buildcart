package com.buildcart.app.modules.catogories.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.CategoriesResponse
import com.buildcart.app.databinding.FragmentCatogoriesBinding
import com.buildcart.app.modules.catogories.`data`.model.CatogoriesRowModel
import com.buildcart.app.modules.catogories.`data`.model.SpinnerGroup122Model
import com.buildcart.app.modules.catogories.`data`.viewmodel.CatogoriesVM
import com.buildcart.app.modules.frame311.ui.Frame311Activity
import com.buildcart.app.modules.homeone.adapter.CategoryAdapter
import com.buildcart.app.modules.homeone.data.CategoriesRepository
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModelFactory
import com.buildcart.app.modules.homeone.ui.AllProductsActivity
import com.buildcart.app.modules.signuofifteen.ui.ProfileActivity
import com.buildcart.app.modules.tile.ui.TileActivity
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.Int
import kotlin.String
import kotlin.Unit

class CatogoriesFragment : BaseFragment<FragmentCatogoriesBinding>(R.layout.fragment_catogories), CategoryAdapter.OnCategoryItemClickListener {
  private val viewModel: CatogoriesVM by viewModels<CatogoriesVM>()

  private val productsRepository = ProductsRepository(APIManager.apiInterface)
  private val categoriesRepository= CategoriesRepository(APIManager.apiInterface)
  private val viewModelHome: HomeOneViewModel by viewModels { HomeOneViewModelFactory(productsRepository,categoriesRepository) }

  private lateinit var apiInterface: APIInterface

  private lateinit var sessionManager: SessionManager
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    sessionManager = SessionManager(requireContext())
    apiInterface = APIManager.apiInterface
    setUpClicks()
    getProfiledata()
    viewModelHome.fetchCategoryList()
  }
  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    //viewModel.spinnerGroup122List.value = mutableListOf(
//    SpinnerGroup122Model("Item1"),
//    SpinnerGroup122Model("Item2"),
//    SpinnerGroup122Model("Item3"),
//    SpinnerGroup122Model("Item4"),
//    SpinnerGroup122Model("Item5")
//    )
//    val spinnerGroup122Adapter =
//    SpinnerGroup122Adapter(requireActivity(),R.layout.spinner_item,viewModel.spinnerGroup122List.value?:
//    mutableListOf())
//    binding.spinnerGroup122.adapter = spinnerGroup122Adapter
//    val catogoriesAdapter = CatogoriesAdapter(viewModel.catogoriesList.value?:mutableListOf())
//    binding.recyclerCatogories.adapter = catogoriesAdapter
//    catogoriesAdapter.setOnItemClickListener(
//    object : CatogoriesAdapter.OnItemClickListener {
//      override fun onItemClick(view:View, position:Int, item : CatogoriesRowModel) {
//        onClickRecyclerCatogories(view, position, item)
//      }
//    }
//    )
//    viewModel.catogoriesList.observe(requireActivity()) {
//      catogoriesAdapter.updateData(it)
//    }


    binding.imageEllipseTwelve.setOnClickListener {
      val i=Intent(requireActivity(),ProfileActivity::class.java)
      startActivity(i)
    }

    // Observe changes in the category list LiveData and update the adapter
    viewModelHome.getCategoriesList().observe(viewLifecycleOwner) { categoryList ->
      Log.d("HomeOneFragment", "Category Data changed: $categoryList")
      if (categoryList != null) {
        // Update the adapter with the category list
        binding.recyclerCatogories.apply {
          layoutManager = GridLayoutManager(
            requireActivity(),3
          )
          adapter = CategoryAdapter(categoryList,viewModelHome,this@CatogoriesFragment)
        }
      }
    }

    binding.catogoriesVM = viewModel
  }
  override fun onCategoryItemClick(categoryItem: CategoriesResponse) {
    // Handle item click and open AllProductsActivity with the selected category
    val intent = Intent(requireActivity(), AllProductsActivity::class.java)
    intent.putExtra("categoryId", categoryItem.id.toString())
    Log.d("selectedCategoryID",categoryItem.id.toString())
    startActivity(intent)
    requireActivity().onBackPressed()
  }

  override fun setUpClicks(): Unit {

    binding.imageVector.setOnClickListener {
      // Open Frame311Activity -MenuDrawer Activity when ImageVector is clicked
      val intent = Intent(activity, Frame311Activity::class.java)
      startActivity(intent)
    }
  }


  fun getProfiledata(){

    val accessToken=sessionManager.fetchAuthToken()

    val authorization="Bearer $accessToken"
    val call=apiInterface.getProfileDetails(authorization)
    call.enqueue(object : Callback<ProfileDataResponse> {
      override fun onResponse(call: Call<ProfileDataResponse>, response: Response<ProfileDataResponse>) {
        if (response.isSuccessful) {

          val loginResponse = response.body()
          if (loginResponse != null) {
            //Toast.makeText(this@ProfileActivity, "Profile Data Successfully Fetched", Toast.LENGTH_LONG).show()




            val file=APIManager.getImageUrl(loginResponse.response!!.photo.toString())




            Picasso.get().load(file).transform(ProfileActivity.CircleCrop()).placeholder(R.drawable.default_profile_background).into(binding.imageEllipseTwelve)


            //navigateToHomeActivity()
          } else {
            Toast.makeText(requireActivity(), "Profile Data fetching failed", Toast.LENGTH_SHORT).show()
          }
        } else {
          Toast.makeText(requireActivity(), "Profile Data fetching Failed", Toast.LENGTH_SHORT).show()
        }
      }
      override fun onFailure(call: Call<ProfileDataResponse>, t: Throwable) {
        Toast.makeText(requireActivity(), "Profile Data fetching: ${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }
  fun onClickRecyclerCatogories(
    view: View,
    position: Int,
    item: CatogoriesRowModel
  ): Unit {
    when(view.id) {
      R.id.linearColumncategoryone ->  {
        val destIntent = TileActivity.getIntent(requireActivity(), null)
        startActivity(destIntent)
        requireActivity().onBackPressed()
      }
    }
  }

  companion object {
    const val TAG: String = "CATOGORIES_FRAGMENT"


    fun getInstance(bundle: Bundle?): CatogoriesFragment {
      val fragment = CatogoriesFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
