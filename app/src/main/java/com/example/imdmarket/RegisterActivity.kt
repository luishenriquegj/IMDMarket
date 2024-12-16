package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityRegisterBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils
import com.example.imdmarket.sharedPreferencesUtils.Utils.Companion.escapeJsonString

class RegisterActivity : AppCompatActivity() {
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
            val productName = binding.productNameInput.text.toString().trim()
            val productCode = binding.productCodeInput.text.toString().toIntOrNull()
            val productStock = binding.stockInput.text.toString().toIntOrNull()
            val productDescription = escapeJsonString(binding.productDescInput.text.toString().trim())

            when {
                productName.isEmpty() -> {
                    Toast.makeText(this, "Please add a valid product name", Toast.LENGTH_LONG).show()
                }
                productCode == null || productCode <= 0 -> {
                    Toast.makeText(this, "Please add a valid product code (a positive number)", Toast.LENGTH_LONG).show()
                }
                productStock == null || productStock <= 0 -> {
                    Toast.makeText(this, "Please add a valid stock quantity (greater than 0)", Toast.LENGTH_LONG).show()
                }
                productDescription.isEmpty() -> {
                    Toast.makeText(this, "Please add a product description", Toast.LENGTH_LONG).show()
                }

                else -> {
                    val currentProducts = Utils.getProducts(this)

                    if (currentProducts.any { it.id == productCode }) {
                        Toast.makeText(this, "A product with this ID already exists. Please use a different ID.", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }

                    // Add new product
                    val product = Product(
                        productName,
                        productCode,
                        productDescription,
                        productStock
                    )
                    currentProducts.add(product)

                    // Save updated product list back to storage
                    Utils.saveProductsArrayList(this, ArrayList(currentProducts)) // Convert back to ArrayList if necessary

                    Toast.makeText(this, "Product saved successfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MenuActivity::class.java))
                    finish()
                }
            }
        }


        clearBtn.setOnClickListener {
            productNameInput.text.clear()
            productStockInput.text.clear()
            productDescriptionInput.text.clear()
            productCodeInput.text.clear()
            Toast.makeText(this, "All field values were cleared", Toast.LENGTH_SHORT).show()
        }

        returnBtn.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}
