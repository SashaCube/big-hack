package com.cubesoft.oleksandr.havryliuk.big_hack.data.api

import com.cubesoft.oleksandr.havryliuk.big_hack.data.model.EventsContainer
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("events")
    fun getEventsByTag(@Query("tag") tag: String): Call<EventsContainer>

    companion object {

//        val client: OkHttpClient = with(HttpLoggingInterceptor()){
//            level = HttpLoggingInterceptor.Level.BODY
//            OkHttpClient().newBuilder().addInterceptor(this).build()
//        }

        const val BASE_URL = "http://10.4.32.17:8082/api/"
        fun create(): Api = Retrofit.Builder()
            //.client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}