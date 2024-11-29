package com.example.imdmarket

import com.example.imdmarket.sharedPreferencesUtils.Utils
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityCadastrarBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils.Companion.escapeJsonString

class CadastrarActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saveBtn = binding.saveButton

        saveBtn.setOnClickListener {
            val productName = binding.productNameInput.text.toString()
            val productCode = binding.productCodeInput.text.toString().toIntOrNull() ?: 0
            val productStock = binding.stockQuantityInput.text.toString().toIntOrNull() ?: 0
            val productDescription = escapeJsonString(binding.productDescInput.text.toString())


            val product = Product(productName, productCode, productDescription,productStock)

            val currentProducts: ArrayList<Product> = Utils.getProducts(this)

            currentProducts.add(product)

            Utils.saveProductsArrayList(this, currentProducts)

            Toast.makeText(this, "Product saved successfully!", Toast.LENGTH_SHORT).show()
            println(Utils.getProducts(this))
        }
    }
}