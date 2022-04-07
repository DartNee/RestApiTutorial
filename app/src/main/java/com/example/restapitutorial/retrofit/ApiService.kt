package com.example.restapitutorial.retrofit

import com.example.restapitutorial.utils.Constants.API_GET_USER
import com.example.restapitutorial.utils.Constants.API_PUT_USER
import com.example.restapitutorial.utils.Constants.API_USER
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @GET(API_GET_USER)
    fun getUser(@Path(value = "id", encoded = true)page :Int): Call<JsonElement>

    // firstName, lastName, email, password
    @FormUrlEncoded
    @POST(API_USER)
    fun createUser(@Field("title") title:String,
                   @Field("body") body:String,
                   @Field("userId") userId: Int
    ) : Call<JsonElement>

    @FormUrlEncoded
    @PUT(API_PUT_USER)
    fun updateUser(@Field("firstName") firstName :String,
                   @Field("lastName") lastName :String,
                   @Field("email") email :String,
                   @Field("password") password :String,
                   @Path(value = "userId", encoded = true)userId :String
    ) : Call<JsonElement>


}
