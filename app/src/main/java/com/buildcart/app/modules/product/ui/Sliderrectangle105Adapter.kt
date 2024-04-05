package com.buildcart.app.modules.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.buildcart.app.databinding.SlideritemProduct1Binding
import com.buildcart.app.modules.product.`data`.model.ImageSliderSliderrectangle105Model
import java.util.ArrayList
import kotlin.Boolean
import kotlin.Int

class Sliderrectangle105Adapter(
  val dataList: ArrayList<ImageSliderSliderrectangle105Model>,
  val mIsInfinite: Boolean
) : LoopingPagerAdapter<ImageSliderSliderrectangle105Model>(dataList, mIsInfinite) {
  override fun bindView(
    binding: ViewBinding,
    listPosition: Int,
    viewType: Int
  ) {
    if (binding is SlideritemProduct1Binding) {
      binding.imageSliderSliderrectangle105Model = dataList[listPosition]
    }
  }

  override fun inflateView(
    viewType: Int,
    container: ViewGroup,
    listPosition: Int
  ): ViewBinding {
    val itemBinding =  SlideritemProduct1Binding.inflate(
    LayoutInflater.from(container.context),
                    container,
                    false
    )
    return itemBinding
  }
}
