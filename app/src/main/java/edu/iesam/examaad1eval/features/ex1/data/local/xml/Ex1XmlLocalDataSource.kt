package edu.iesam.examaad1eval.features.ex1.data.local.xml

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.model.Item
import edu.iesam.examaad1eval.features.ex1.model.Services
import edu.iesam.examaad1eval.features.ex1.model.User

class Ex1XmlLocalDataSource(context: Context) {

    private val sharedPref = context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        sharedPref.edit().apply {
            putString("users", users.map { gson.toJson(it) }.toString())
            apply()
        }
    }

    fun saveItems(items: List<Item>) {
        sharedPref.edit().apply {
            putString("items", items.map { gson.toJson(it) }.toString())
            apply()
        }
    }


    fun saveServices(services: List<Services>) {
        sharedPref.edit().apply {
            putString("services", services.map { gson.toJson(it) }.toString())
            apply()
        }
    }

    fun getUsers(): List<User> {
        val usersJson = sharedPref.getString("users", null) ?: return emptyList()
        return gson.fromJson(usersJson, Array<User>::class.java).toList()
    }

    fun getItems(): List<Item> {
        val itemsJson = sharedPref.getString("items", null) ?: return emptyList()
        return gson.fromJson(itemsJson, Array<Item>::class.java).toList()
    }

    fun getServices(): List<Services> {
        val servicesJson = sharedPref.getString("services", null) ?: return emptyList()
        return gson.fromJson(servicesJson, Array<Services>::class.java).toList()
    }
}
