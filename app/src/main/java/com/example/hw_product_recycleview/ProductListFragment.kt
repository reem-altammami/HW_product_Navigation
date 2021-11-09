package com.example.hw_product_recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.adapter.ProductAdapter
import com.example.hw_product_recycleview.data.DataSource
import com.example.hw_product_recycleview.databinding.FragmentProductListBinding

private var _binding :FragmentProductListBinding? = null
private val binding get() = _binding!!
private lateinit var recyclerView: RecyclerView

class ProductListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val productData = DataSource().loadProduct()
        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ProductAdapter(this.requireContext(),productData)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}