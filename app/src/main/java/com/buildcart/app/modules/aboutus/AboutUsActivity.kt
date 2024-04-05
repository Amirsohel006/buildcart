package com.buildcart.app.modules.aboutus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.responses.AboutUsResponses
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response

class AboutUsActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var  recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        sessionManager= SessionManager(this)
       recyclerView=findViewById(R.id.recyclerview)
        val serviceGenerator = APIManager.apiInterface
        val accessToken=sessionManager.fetchAuthToken()
        val authorization="Bearer $accessToken"
        val call = serviceGenerator.getAboutUs(authorization)

        call.enqueue(object : retrofit2.Callback<AboutUsResponses> {
            override fun onResponse(
                call: Call<AboutUsResponses>,
                response: Response<AboutUsResponses>
            ) {
                if (response.isSuccessful) {
                    val storedResponse=response.body()
                    recyclerView.apply {
                        layoutManager= LinearLayoutManager(this@AboutUsActivity)
                        adapter=AboutUsAdapter(storedResponse!!.response)
                    }
                }
            }

            override fun onFailure(call: Call<AboutUsResponses>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })

        window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
    }
}