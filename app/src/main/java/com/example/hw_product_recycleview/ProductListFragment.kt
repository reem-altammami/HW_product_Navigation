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
import com.example.hw_product_recycleview.model.Product

private var _binding :FragmentProductListBinding? = null
private val binding get() = _binding!!
private lateinit var recyclerView: RecyclerView
lateinit var pr :List<Product>
class ProductListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         pr = DataSource().loadProduct()

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
        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ProductAdapter(this.requireContext(),pr)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}