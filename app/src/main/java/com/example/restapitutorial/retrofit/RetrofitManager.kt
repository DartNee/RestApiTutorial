package com.example.restapitutorial.retrofit

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.restapitutorial.App
import com.example.restapitutorial.EditUserActivity
import com.example.restapitutorial.model.User
import com.example.restapitutorial.utils.Constants.API_BASE_URL
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    val TAG: String = "로그"

    companion object {

        val instance = RetrofitManager()
    }

    private val httpCall : ApiService? = RetrofitClient.getClient(API_BASE_URL)?.create(ApiService::class.java)

    fun getUserPaginate(page: Int) {
        val call = httpCall?.getUser(page.toString().toInt())
        //we call the new enqueue
        call?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

            }

        })
    }

    fun getFirstUser() {
        val call = httpCall?.getUser(1)
        //we call the new enqueue
        call?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

                response.body()?.let {
//                    Log.d(TAG, "it : ${it}")

                    val jsonObj = it.asJsonObject

                    val fetchedUsersJsonArray = jsonObj.get("fetchedUsersPerPage").asJsonArray

                    val firstUserJson = fetchedUsersJsonArray.get(0).asJsonObject
//                    Log.d(TAG, "fetchedUsersJsonArray : ${fetchedUsersJsonArray}")

                    Log.d(TAG, "firstUserJson : ${firstUserJson}")

                    val firstUser = User(firstName = firstUserJson.get("firstName").asString,
                                        lastName = firstUserJson.get("lastName").asString,
                                        email = firstUserJson.get("email").asString,
                                        password = firstUserJson.get("password").asString)

                    val intent = Intent(App.instance, EditUserActivity::class.java)

                    intent.putExtra("firstUser", firstUser)

                    App.instance.startActivity(intent)

                }

            }

        })
    }




    fun createUser(title: String, body: String, userId: Int){
        val call = httpCall?.createUser(title, body, userId)
        call?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
            }

        })
    }

    fun updateUser(firstName: String, lastName: String, email: String, password: String){

        val call = httpCall?.updateUser(firstName, lastName, email, password, "1")

        call?.enqueue(object : retrofit2.Callback<JsonElement>{

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

                Toast.makeText(App.instance, response.body().toString(), Toast.LENGTH_SHORT).show()

            }

        })
    }

}
