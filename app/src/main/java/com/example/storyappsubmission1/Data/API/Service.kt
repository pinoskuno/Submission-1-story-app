package com.storyappsubmission1.Data.API

import com.storyappsubmission1.Data.Response.GeneralR
import com.storyappsubmission1.Data.Response.LoginR
import com.storyappsubmission1.Data.Response.StoryR
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<GeneralR>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginR>

    @Multipart
    @POST("stories")
    fun addStories(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
        @Part("lat") lat: Float,
        @Part("lon") lon: Float
    ): Call<GeneralR>

    @GET("stories")
    fun getStories(
        @Header("Authorization") token: String
    ): Call<StoryR>
}