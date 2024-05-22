package com.buildcart.app.service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIManager {

    val BASE_URL = "https://9c4c-2405-201-d02f-a029-b02b-e7c-2380-2026.ngrok-free.app"


    // API response interceptor
    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    // Client
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val  apiInterface : APIInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client)
            .build()
            .create(APIInterface::class.java)
    }


    fun getImageUrl(imagePath: String): String {
        return BASE_URL + imagePath
    }


}