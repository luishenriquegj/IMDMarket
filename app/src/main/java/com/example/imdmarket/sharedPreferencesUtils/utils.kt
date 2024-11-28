package com.example.imdmarket.sharedPreferencesUtils

import android.content.Context
import android.content.SharedPreferences
import com.example.imdmarket.Product
import com.google.gson.Gson

class Utils {

    companion object {



        fun saveProductsArrayList(context: Context, list: MutableList<Product>) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("productsPref", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()

            val json = gson.toJson(list)
            editor.putString("products", json)
            editor.apply()
        }

        fun getProducts(context: Context): MutableList<Product> {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("productsPref", Context.MODE_PRIVATE)
            val productSet: Set<String> = sharedPreferences.getStringSet("products", setOf()) ?: setOf()

            val gson = Gson()
            val products = ArrayList<Product>()

            for (productJson in productSet) {
                val product = gson.fromJson(productJson, Product::class.java)
                products.add(product)
            }

            return products
        }

    }
}

