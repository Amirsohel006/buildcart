package com.buildcart.app.modules.homeone.ui
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.data.ProductResponseItem
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.CategoriesResponse
import com.buildcart.app.databinding.FragmentHomeOneBinding
import com.buildcart.app.modules.frame311.ui.Frame311Activity
import com.buildcart.app.modules.homeone.adapter.CategoryAdapter
import com.buildcart.app.modules.homeone.adapter.HomeOneAdapter
import com.buildcart.app.modules.homeone.data.CategoriesRepository
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneVM
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModelFactory
import com.buildcart.app.modules.mycart.ui.MyCartFragment
import com.buildcart.app.modules.signuofifteen.ui.ProfileActivity
import com.buildcart.app.service.APIManager

class HomeOneFragment : BaseFragment<FragmentHomeOneBinding>(R.layout.fragment_home_one) {

  private val viewModel: HomeOneVM by viewModels()
  private lateinit var homeOneAdapter: HomeOneAdapter
  private val productsRepository = ProductsRepository(APIManager.apiInterface)
  private val categoriesRepository=CategoriesRepository(APIManager.apiInterface)
  private val viewModelHome: HomeOneViewModel by viewModels { HomeOneViewModelFactory(productsRepository,categoriesRepository) }
  private lateinit var txtViewAll:TextView
  private lateinit var sessionManager: SessionManager



  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    sessionManager = SessionManager(requireActivity())
    // Set the session manager
    viewModelHome.setSessionManager(SessionManager(requireContext()))
    setUpClicks()
    viewModelHome.fetchProductList()
    viewModelHome.fetchCategoryList()
    // Find and set click listener for txtViewAll
    txtViewAll = binding.root.findViewById(R.id.txtViewAll)
    txtViewAll.setOnClickListener {
      val intentAllProducts = Intent(requireActivity(), AllProductsActivity::class.java)
      startActivity(intentAllProducts)
    }

  }

  override fun onInitialized() {
    sessionManager = SessionManager(requireActivity())
    binding.homeOneVM = viewModel
    binding.homeOneViewModel = viewModelHome




    homeOneAdapter = HomeOneAdapter(mutableListOf(), viewModelHome,sessionManager,requireActivity().getSharedPreferences("favourites", Context.MODE_PRIVATE),requireActivity())
    binding.recyclerHomeOne.apply {
      layoutManager = GridLayoutManager(requireContext(), 2)
      adapter = homeOneAdapter
    }

    // Observe changes in the LiveData and update the adapter
    viewModelHome.getProductList().observe(viewLifecycleOwner) { dataList ->
      Log.d("HomeOneFragment", "Data changed: $dataList")
      if (dataList != null) {
        homeOneAdapter.updateData(dataList)
      }
    }


    // Observe changes in the category list LiveData and update the adapter
    viewModelHome.getCategoriesList().observe(viewLifecycleOwner) { categoryList ->
      Log.d("HomeOneFragment", "Category Data changed: $categoryList")
      if (categoryList != null) {
        // Update the adapter with the category list
        binding.recyclerViewProductCategories.apply {
          layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
          )

          adapter = CategoryAdapter(categoryList, viewModelHome, object : CategoryAdapter.OnCategoryItemClickListener {
            override fun onCategoryItemClick(categoryItem: CategoriesResponse) {
              // Handle category item click
              // You can implement logic to navigate to AllProductsActivity with the selected category
              val intentAllProducts = Intent(requireActivity(), AllProductsActivity::class.java)
              intentAllProducts.putExtra("categoryId", categoryItem.id.toString())
              startActivity(intentAllProducts)
            }

          })

        }

      }
    }



    viewModelHome.addToCartButtonText.observe(viewLifecycleOwner) {  pair ->
      pair?.let {
        val position = pair.first
        val buttonText = pair.second
      homeOneAdapter.setAddToCartButtonText(position, buttonText)
        homeOneAdapter.notifyItemChanged(position)
      Log.d("HomeOneFragment", "Button text changed for position $position: $buttonText")}


    }


    // Observe _navigateToCartFragment for navigation to the CartFragment
    viewModelHome.navigateToCartFragment.observe(viewLifecycleOwner) { navigate ->
      if (navigate) {
        // Handle navigation to the CartFragment here
        val cartFragment = MyCartFragment.getInstance(null)
        requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.fragmentContainer, cartFragment)
          .addToBackStack(null)
          .commit()

        // Reset the value to prevent repeated navigation
        viewModelHome.onNavigationToCartComplete()
      }
    }

    binding.imageEllipseProfile.setOnClickListener {
      val intentProfile = Intent(requireActivity(), ProfileActivity::class.java)
      startActivity(intentProfile)
    }
  }

  override fun setUpClicks() {
    //menu drawer
    binding.imageVector.setOnClickListener {
      // Open Frame311Activity -MenuDrawer Activity when ImageVector is clicked
      val intent = Intent(activity, Frame311Activity::class.java)
      startActivity(intent)
    }


    // Set up click events for increase and decrease quantity
    homeOneAdapter.setOnItemClickListener(object : HomeOneAdapter.OnItemClickListener {
      override fun onIncreaseClick(view: View, position: Int, item: ProductResponseItem) {
        viewModelHome.onPlusClick(item)
      }

      override fun onDecreaseClick(view: View, position: Int, item: ProductResponseItem) {
        viewModelHome.onMinusClick(item)
      }

      override fun onAddToCartClick(view: View, position: Int, item: ProductResponseItem) {
        viewModelHome.setSelectedProduct(item)
        viewModelHome.onAddToCartClick(item,position)
        homeOneAdapter.setAddToCartButtonText(position, "Go to Cart")
      }

      // Add a new method for handling "Go to Cart" action
      override fun onGoToCartClick(view: View, position: Int, item: ProductResponseItem) {
        viewModelHome.onGoToCartClick(item)
      }

      override fun onItemClick(view: View, position: Int, item: ProductResponseItem) {
        // Implement logic for item click
        // Example: viewModelHome.onItemClick(item)
      }
    })
  }

  companion object {
    const val TAG: String = "HOME_ONE_FRAGMENT"

    fun getInstance(bundle: Bundle?): HomeOneFragment {
      val fragment = HomeOneFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
