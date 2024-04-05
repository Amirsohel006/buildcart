package com.buildcart.app.modules.orders.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.FragmentOrdersSectionBinding
import com.buildcart.app.modules.orders.adapter.OrdersAdapter
import com.buildcart.app.modules.orders.data.model.OrdersRepository
import com.buildcart.app.modules.orders.data.model.OrdersViewModelFactory
import com.buildcart.app.modules.orders.data.model.Section
import com.buildcart.app.modules.orders.data.viewmodel.OrdersResponse
import com.buildcart.app.modules.orders.data.viewmodel.OrdersSectionVM
import com.buildcart.app.service.APIManager

class OrdersSectionFragment : Fragment(R.layout.fragment_orders_section) {

    private lateinit var binding: FragmentOrdersSectionBinding
    private lateinit var ordersAdapter: OrdersAdapter
    private val ordersRepository = OrdersRepository(APIManager.apiInterface)

    private var currentSection: Section? = null
    private val viewModel: OrdersSectionVM by viewModels { OrdersViewModelFactory(ordersRepository) }

    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersSectionBinding.inflate(inflater, container, false)

        sessionManager = SessionManager(requireContext())
        // Set the session manager
        viewModel.setSessionManager(SessionManager(requireContext()))
        // Get the section from arguments
        currentSection = arguments?.getSerializable(ARG_SECTION) as? Section

        if (currentSection == null) {
            Toast.makeText(requireActivity(), "No Orders to Show", Toast.LENGTH_SHORT).show()
            return binding.root
        }

        ordersAdapter = OrdersAdapter(OrdersResponse("", "", emptyList()))
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ordersAdapter

        when (currentSection) {
            Section.ACTIVE -> {
                viewModel.getActiveOrders()
            }
            Section.COMPLETED -> {
                viewModel.getCompletedOrders()
            }
            Section.CANCELLED -> {
                viewModel.getCancelledOrders()
            }
            else -> {
                // Handle the case when currentSection is not one of the expected values
                // For example, you can provide a default behavior or log a warning
            }
        }

        // Observe LiveData based on the current section
        observeOrders()

        return binding.root
    }

    private fun observeOrders() {
        when (currentSection) {
            Section.ACTIVE -> {
                viewModel.activeOrders.observe(viewLifecycleOwner) { orders ->
                    updateUI(orders)
                }
            }
            Section.COMPLETED -> {
                viewModel.completedOrders.observe(viewLifecycleOwner) { orders ->
                    updateUI(orders)
                }
            }
            Section.CANCELLED -> {
                viewModel.cancelledOrders.observe(viewLifecycleOwner) { orders ->
                    updateUI(orders)
                }
            }
            else -> {
                // Handle the case when currentSection is not one of the expected values
                // For example, you can provide a default behavior or log a warning
            }
        }
    }

    private fun updateUI(orders: OrdersResponse) {
        // Update UI based on the orders for the current section
        // You can access the orders list here and update your RecyclerView or other UI components
        ordersAdapter.updateData(orders)
    }

    companion object {
        private const val ARG_SECTION = "section"

        @JvmStatic
        fun newInstance(section: Section): OrdersSectionFragment {
            return OrdersSectionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_SECTION, section)
                }
            }
        }
    }
}
