package com.buildcart.app.modules.orders.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.orders.data.model.OrderStatusRequest
import com.buildcart.app.modules.responses.CategoriesResponse
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response

class ActiveOrdersFragment : Fragment() {

    private lateinit var sessionManager: SessionManager

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager= SessionManager(requireActivity())
        fetchActiveorder()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_orders, container, false).apply {
            recyclerView=findViewById(R.id.recyclerStudioBookong)
        }
    }


    private fun fetchActiveorder() {
        val serviceGenerator = APIManager.apiInterface
        val accessToken = sessionManager.fetchAuthToken()
        val authorization = "Bearer $accessToken"
        val orderStatusRequest = OrderStatusRequest(status = "pending")
        val call = serviceGenerator.getActiveOrder(authorization,orderStatusRequest)



        call.enqueue(object : retrofit2.Callback<CategoriesResponse> {
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {
                if (response.isSuccessful) {
                    val customerResponse=response.body()

                    if((customerResponse!=null)   && (customerResponse.success=="true")) {
                        val activedata=response.body()
                        recyclerView.apply {
                            layoutManager=
                                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
                            val audtioAdapter= ActiveOrderAdapter(activedata!!.response)
                            recyclerView.adapter=audtioAdapter
                        }

                    }

                } else {

                }
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                t.printStackTrace()

            }
        })
    }


}