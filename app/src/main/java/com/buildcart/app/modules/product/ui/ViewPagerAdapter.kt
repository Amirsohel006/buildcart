package com.buildcart.app.modules.product.ui
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.buildcart.app.R
import com.buildcart.app.modules.product.data.model.ImageSliderSliderrectangle105Model
import com.bumptech.glide.Glide

class ViewPagerAdapter(
    private val context: Context,
    private val imageList: List<ImageSliderSliderrectangle105Model>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_image_slider, container, false) as ViewGroup

        val imageView = view.findViewById<ImageView>(R.id.imageViewSlider)
        Glide.with(context)
            .load(imageList[position].imageRectangle105)
            .into(imageView)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = imageList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}
