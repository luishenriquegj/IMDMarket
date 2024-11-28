package com.example.imdmarket

import com.example.imdmarket.sharedPreferencesUtils.Utils
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityCadastrarBinding

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
            val productDescription = binding.productDescInput.text.toString()

            val product = Product(productName, productCode, productDescription,productStock)

            // Retrieve the current list of products
            val currentProducts: MutableList<Product> = Utils.getProducts(this)

            // Add the new product to the list
            currentProducts.add(product)

            // Save the updated list back to SharedPreferences
            Utils.saveProductsArrayList(this, currentProducts)

            // Show a confirmation message
            Toast.makeText(this, "Product saved successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}