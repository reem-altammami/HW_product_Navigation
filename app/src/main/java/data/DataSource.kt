package data

import com.example.hw_product_recycleview.R
import model.Product

class DataSource {
    fun loadProduct (): List<Product> {
        val productList = mutableListOf<Product>()
        productList.add(Product(R.drawable.iphone, "Iphone 12 64GB", 4500,true,5))
        productList.add(Product(R.drawable.samsung_galaxy_uitra, "Samsung Galaxy S21 Ultra", 4500,false,5))
        productList.add(Product(R.drawable.xiaomi_pro, "Xiaomi 11T Pro", 2000,true,0))
        productList.add(Product(R.drawable.huawei_yp, "Huawei Y6p", 500,false,0))
        productList.add(Product(R.drawable.samsung_galaxy_z_flip, "Samsung Galaxy Z Flip3", 5000,true,70))
        productList.add(Product(R.drawable.iphone13, "Iphone 13", 6000,true,36))
        return productList
    }
}