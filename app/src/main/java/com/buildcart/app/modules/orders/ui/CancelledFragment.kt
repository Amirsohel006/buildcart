package com.buildcart.app.modules.orders.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.orders.data.model.OrderStatusRequest
import com.buildcart.app.modules.responses.CancelledResponse
import com.buildcart.app.modules.responses.CompltedOrderResponse
import com.buildcart.app.service.APIManager
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private lateinit var sessionManager: SessionManager
private lateinit var recyclerView: RecyclerView
/**
 * A simple [Fragment] subclass.
 * Use the [CancelledFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CancelledFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager= SessionManager(requireActivity())
        fetchCancelledOrders()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancelled, container, false).apply {
            recyclerView=findViewById(R.id.recyclerStudioBookong)
        }
    }


    private fun fetchCancelledOrders() {
        val serviceGenerator = APIManager.apiInterface
        val accessToken = sessionManager.fetchAuthToken()
        val authorization = "Bearer $accessToken"
        val orderStatusRequest = OrderStatusRequest(status = "cancelled")
        val call = serviceGenerator.getCancelledOrder(authorization,orderStatusRequest)



        call.enqueue(object : retrofit2.Callback<CancelledResponse> {
            override fun onResponse(call: Call<CancelledResponse>, response: Response<CancelledResponse>) {
                if (response.isSuccessful) {
                    val customerResponse=response.body()


                        recyclerView.apply {
                            layoutManager=
                                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
                            val audtioAdapter= CancelledOrderAdapter(listOf( customerResponse!!))
                            recyclerView.adapter=audtioAdapter
                        }

                    }


            }

            override fun onFailure(call: Call<CancelledResponse>, t: Throwable) {
                t.printStackTrace()

            }
        })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CancelledFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CancelledFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}