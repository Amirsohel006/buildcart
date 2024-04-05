package com.buildcart.app.modules.homeonecontainer.ui

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityHomeOneContainerBinding
import com.buildcart.app.extensions.loadFragment
import com.buildcart.app.modules.catogories.ui.CatogoriesFragment
import com.buildcart.app.modules.homeone.ui.HomeOneFragment
import com.buildcart.app.modules.homeonecontainer.`data`.viewmodel.HomeOneContainerVM
import com.buildcart.app.modules.mycart.ui.MyCartFragment
import com.buildcart.app.modules.orders.ui.OrdersFragment
import com.buildcart.app.modules.signuofifteen.ui.ProfileActivity
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlin.String
import kotlin.Unit

class HomeOneContainerActivity :
    BaseActivity<ActivityHomeOneContainerBinding>(R.layout.activity_home_one_container) {
  private val viewModel: HomeOneContainerVM by viewModels<HomeOneContainerVM>()


  private lateinit var sessionManager: SessionManager

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homeOneContainerVM = viewModel

    sessionManager= SessionManager(this)

    replaceFragment(HomeOneFragment())

    Picasso.get().load(sessionManager.fetchProfileImage()).transform(ProfileActivity.CircleCrop()).placeholder(R.drawable.default_profile_background).into(binding.imageEllipseProfile)

    window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)




  }

  override fun setUpClicks(): Unit {

    binding.imageEllipseProfile.setOnClickListener {
      val intentProfile = Intent(this, ProfileActivity::class.java)
      startActivity(intentProfile)
    }


    binding.frameBottombar.setOnItemSelectedListener {

      when(it.itemId ){
        R.id.linearColumnhome1 -> {
          replaceFragment(HomeOneFragment())
        }

        R.id.linearColumncategories -> replaceFragment(CatogoriesFragment())


        R.id.linearColumnOrders-> replaceFragment(OrdersFragment())

        R.id.linearColumnProfile -> replaceFragment(MyCartFragment())

        else -> {
        }
      }
      true

    }


  }



  private fun replaceFragment(fragment: Fragment) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    // Check if the fragment is already in the back stack
    val existingFragment = fragmentManager.findFragmentByTag(fragment.javaClass.simpleName)

    if (existingFragment == null) {
      fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragment.javaClass.simpleName)
      fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
      fragmentTransaction.commit()
    } else {
      // If the fragment already exists, simply pop the back stack up to it
      fragmentManager.popBackStackImmediate(existingFragment.javaClass.simpleName, 0)
    }
  }




  @Deprecated("Deprecated in Java")
  override fun onBackPressed() {
    val fragmentManager=supportFragmentManager
    val fragments = supportFragmentManager.backStackEntryCount
    if (fragments == 1) {
      AlertDialog.Builder(this)
        .setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes",
          DialogInterface.OnClickListener { dialog, id -> finish() })
        .setNegativeButton("No", null)
        .show()
    }
    else {

      if (fragmentManager.backStackEntryCount > 1) {
        fragmentManager.popBackStackImmediate(
          fragmentManager.getBackStackEntryAt(1).id,
          FragmentManager.POP_BACK_STACK_INCLUSIVE
        )

        var selectedFragment: Fragment? = null
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments) {
          if (fragment != null && fragment.isVisible) {
            selectedFragment = fragment
            break
          }
        }



        if(selectedFragment is HomeOneFragment){
          binding.frameBottombar.selectedItemId = R.id.linearColumnhome1
        }
        if (selectedFragment is CatogoriesFragment) {
          binding.frameBottombar.selectedItemId = R.id.linearColumncategories
        }
        if (selectedFragment is OrdersFragment) {
          binding.frameBottombar.selectedItemId=R.id.linearColumnOrders
        }
        if (selectedFragment is MyCartFragment)
        {
          binding.frameBottombar.selectedItemId= R.id.linearColumnProfile
        } else {
          super.onBackPressed()
        }
      }
      else {
        super.onBackPressed()
      }
    }
    // }
  }
  companion object {
    const val TAG: String = "HOME_ONE_CONTAINER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomeOneContainerActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }


}
