package com.buildcart.app.modules.orders.ui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import com.buildcart.app.modules.orders.data.model.Section

class OrdersFragmentPagerAdapter(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = viewPages.size

    override fun createFragment(position: Int): Fragment = viewPages[position]

    companion object AdapterConstant {
        @SuppressLint("ResourceType")
        val title: List<String> =
            listOf(
                MyApp.getInstance().resources.getString(R.string.lbl_active),
                MyApp.getInstance().resources.getString(R.string.lbl_completed),
                MyApp.getInstance().resources.getString(R.string.lbl_cancelled))

        val viewPages: List<Fragment> =
            listOf(ActiveOrdersFragment(), CompletedFragment(),CancelledFragment())

    }
}