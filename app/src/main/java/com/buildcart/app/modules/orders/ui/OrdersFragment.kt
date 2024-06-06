package com.buildcart.app.modules.orders.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.FragmentOrdersBinding
import com.buildcart.app.modules.frame311.ui.Frame311Activity
import com.buildcart.app.modules.orders.`data`.viewmodel.OrdersVM
import com.buildcart.app.modules.signuofifteen.ui.ProfileActivity
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class OrdersFragment : BaseFragment<FragmentOrdersBinding>(R.layout.fragment_orders) {
  private val viewModel: OrdersVM by viewModels<OrdersVM>()


  private lateinit var apiInterface: APIInterface

  private lateinit var sessionManager: SessionManager
  override fun onInitialized(): Unit {
    sessionManager = SessionManager(requireContext())
    apiInterface = APIManager.apiInterface
    viewModel.navArguments = arguments
    binding.ordersVM = viewModel


    getProfiledata()
    // Initialize ViewPager2 and TabLayout
    val adapter = OrdersFragmentPagerAdapter(childFragmentManager, lifecycle)
    binding.viewPagerViewpager.adapter = adapter

    // Attach TabLayout to ViewPager2
    TabLayoutMediator(binding.tabLayout, binding.viewPagerViewpager) { tab, position ->
      tab.customView = createTabView(OrdersFragmentPagerAdapter.title[position])
    }.attach()

    // Add dividers between each tab
    //addDividersToTabs(binding.tabLayout)

    binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab?) {
        updateTabText(tab, true)
      }

      override fun onTabUnselected(tab: TabLayout.Tab?) {
        updateTabText(tab, false)
      }

      override fun onTabReselected(tab: TabLayout.Tab?) {
        // Handle reselection if needed
      }
    })

    // Set initial selected tab text color
    val initialTab = binding.tabLayout.getTabAt(binding.tabLayout.selectedTabPosition)
    updateTabText(initialTab, true)


    binding.imageEllipseTwelve.setOnClickListener {
      val i=Intent(requireActivity(),ProfileActivity::class.java)
      startActivity(i)
    }

  }


  private fun createTabView(tabText: String): View {
    val tabView = LayoutInflater.from(context).inflate(R.layout.custom_tab, null)
    val tabTitle = tabView.findViewById<TextView>(R.id.tabTitle)
    tabTitle.text = tabText
    return tabView
  }
  private fun updateTabText(tab: TabLayout.Tab?, isSelected: Boolean) {
    val tabView = tab?.customView
    val tabTitle = tabView?.findViewById<TextView>(R.id.tabTitle)
    if (isSelected) {
      tabTitle?.setTextColor(ContextCompat.getColor(requireContext(), R.color.yellow_A400))
    } else {
      tabTitle?.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
    }
  }


  private fun addDividersToTabs(tabLayout: TabLayout) {
    for (i in 0 until tabLayout.tabCount - 1) {
      val tab = (tabLayout.getChildAt(0) as LinearLayout).getChildAt(i)
      val divider = View(context).apply {
        layoutParams = LinearLayout.LayoutParams(1, 1).apply {
          setMargins(0, 16, 0, 16) // Optional: Adjust margins as needed
        }
        setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_703))
      }
      (tab as LinearLayout).addView(divider)
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




            val file= APIManager.getImageUrl(loginResponse.response!!.photo.toString())




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
  override fun setUpClicks(): Unit {
    // Handle clicks if needed

    binding.imageVector.setOnClickListener {
      // Open Frame311Activity -MenuDrawer Activity when ImageVector is clicked
      val intent = Intent(activity, Frame311Activity::class.java)
      startActivity(intent)
    }
  }

  companion object {
    const val TAG: String = "ORDERS_FRAGMENT"

    fun getInstance(bundle: Bundle?): OrdersFragment {
      val fragment = OrdersFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
