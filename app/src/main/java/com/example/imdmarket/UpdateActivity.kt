package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityUpdateBinding
import com.example.imdmarket.sharedPreferencesUtils.Utils

class UpdateActivity : AppCompatActivity(){
    private lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val productName = binding.productNameInput
        val productCode = binding.productCodeInput
        val productStock = binding.stockInput
        val productDescription = binding.productDescInput
        val saveBtn = binding.saveButton
        val clearBtn = binding.clearButton
        val returnBtn = binding.returnBtn


        saveBtn.setOnClickListener {
            if(productCode.text.isEmpty()){
                Toast.makeText(this, "Id is required to update a product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if( productName.text.isEmpty() && productStock.text.isEmpty() && productDescription.text.isEmpty()){
                Toast.makeText(this, "Fill at least one of the fields to updated a product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val currentProducts = Utils.getProducts(this)

            val existingProduct = currentProducts.find { it.id.toInt() == productCode.text.toString().toInt() }

            if (!currentProducts.any { it.id.toInt() == productCode.text.toString().toInt() }) {
                Toast.makeText(this, "A product with this ID  doesn't exist. Please use a different ID.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (existingProduct == null) {
                Toast.makeText(this, "A product with this ID doesn't exist. Please use a different ID.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            productStock.text.toString().toIntOrNull()?.let {
                existingProduct.stock = it
            }
            if (productName.text.isNotEmpty()) {
                existingProduct.name = productName.text.toString()
            }
            if (productDescription.text.isNotEmpty()) {
                existingProduct.description = productDescription.text.toString()
            }

            // Salvar a lista atualizada de volta no SharedPreferences
            Utils.saveProductsMutableList(this, currentProducts)

            Toast.makeText(this, "Product updated successfully", Toast.LENGTH_SHORT).show()

            // Navegar de volta para a MenuActivity
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

        clearBtn.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
        returnBtn.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

    }
}