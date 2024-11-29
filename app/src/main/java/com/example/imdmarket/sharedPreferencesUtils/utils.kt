package com.example.imdmarket.sharedPreferencesUtils

import android.content.Context
import android.content.SharedPreferences
import com.example.imdmarket.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Utils {

    companion object {
        fun escapeJsonString(input: String): String {
            val stringBuilder = StringBuilder()
            for (char in input) {
                when (char) {
                    '\\' -> stringBuilder.append("\\\\")
                    '"' -> stringBuilder.append("\\\"")
                    '\b' -> stringBuilder.append("\\b")
                    '\n' -> stringBuilder.append("\\n")
                    '\r' -> stringBuilder.append("\\r")
                    '\t' -> stringBuilder.append("\\t")
                    else -> stringBuilder.append(char)
                }
            }
            return stringBuilder.toString()
        }

        fun saveProductsArrayList(context: Context, products: ArrayList<Product>) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("productsPref", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(products)
            editor.putString("products", json)
            editor.apply()
        }

        fun getProducts(context: Context): ArrayList<Product> {
            val sharedPreferences = context.getSharedPreferences("productsPref", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("products", null)
            val type = object : TypeToken<ArrayList<Product>>() {}.type
            return gson.fromJson(json, type) ?: ArrayList()
        }

        fun deleteProductById(context: Context, productId: Number): Boolean {
            val sharedPreferences = context.getSharedPreferences("productsPref", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val json = sharedPreferences.getString("products", null)
            val productType = object : TypeToken<ArrayList<Product>>() {}.type
            val currentProducts: ArrayList<Product> = gson.fromJson(json, productType)

            val iterator = currentProducts.iterator()
            while (iterator.hasNext()) {
                val product = iterator.next()
                if (product.id.toInt() == productId) {
                    iterator.remove()
                    val jsonProducts = gson.toJson(currentProducts)
                    editor.putString("products", jsonProducts)
                    editor.apply()
                    return true
                }
            }
            return false
        }


    }
}

