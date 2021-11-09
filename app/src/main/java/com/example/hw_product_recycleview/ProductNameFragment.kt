package com.example.hw_product_recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_product_recycleview.databinding.FragmentProductNameBinding


class ProductNameFragment : Fragment() {
    companion object{
        const val productName = "name"
    }
private var _binding : FragmentProductNameBinding?= null
    private val binding get() = _binding!!
    lateinit var product:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product = it.getString(productName).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
_binding = FragmentProductNameBinding.inflate(inflater,container,false)
   return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.showProduct.text = product
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}