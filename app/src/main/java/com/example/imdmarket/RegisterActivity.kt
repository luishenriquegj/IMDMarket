package com.example.imdmarket

import android.content.Intent
import com.example.imdmarket.sharedPreferencesUtils.Utils
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityRegisterBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils.Companion.escapeJsonString

class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saveBtn = binding.saveButton
        val clearBtn = binding.clearButton
        val returnBtn = binding.returnBtn

        val productNameInput = binding.productNameInput
        val productCodeInput = binding.productCodeInput
        val productStockInput = binding.stockInput
        val productDescriptionInput = binding.productDescInput

        saveBtn.setOnClickListener {
            val productName = binding.productNameInput.text.toString()
            val productCode = binding.productCodeInput.text.toString().toIntOrNull() ?: 0
            val productStock = binding.stockInput.text.toString().toIntOrNull() ?: 0
            val productDescription = escapeJsonString(binding.productDescInput.text.toString())


            val product = Product(productName, productCode, productDescription,productStock)

            val currentProducts: ArrayList<Product> = Utils.getProducts(this)

            currentProducts.add(product)

            Utils.saveProductsArrayList(this, currentProducts)

            Toast.makeText(this, "Product saved successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MenuActivity::class.java))
            finish()

        }

        clearBtn.setOnClickListener {
            productNameInput.text.clear()
            productStockInput.text.clear()
            productDescriptionInput.text.clear()
            productCodeInput.text.clear()
            Toast.makeText(this, "All field values where cleared", Toast.LENGTH_SHORT).show()
        }

        returnBtn.setOnClickListener {
            productNameInput.text.clear()
            productStockInput.text.clear()
            productDescriptionInput.text.clear()
            productCodeInput.text.clear()
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}