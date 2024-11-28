package com.example.imdmarket

import com.google.gson.Gson
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.ActivityCadastrarBinding

class CadastrarActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding
    var productPrefs: SharedPreferences = getSharedPreferences("productsPref", MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var saveBtn = binding.saveButton

                saveBtn.setOnClickListener {
                    val productName = binding.productNameInput.text.toString()
                    val productCode = binding.productCodeInput.text.toString().toIntOrNull() ?: 0
                    val productStock = binding.stockQuantityInput.text.toString().toIntOrNull() ?: 0
                    val productDescription = binding.productDescInput.text.toString()

                    val product = Product(
                        name = productName,
                        id = productCode,
                        description = productDescription,
                        stock = productStock
                    )

                    val gson = Gson()
                    val productJson = gson.toJson(product)

                    // Save the JSON string to SharedPreferences
                    val sharedPreferences: SharedPreferences = getSharedPreferences("ProductPrefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("product", productJson)
                    editor.apply()

                    // Show a confirmation message
                    Toast.makeText(this, "Product saved successfully!", Toast.LENGTH_SHORT).show()
                }

    }
}