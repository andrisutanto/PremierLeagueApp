package com.appgue.premierleagueapp.Utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Andri on 4/21/2018.
 */
class InitRetrofit {

    fun getInitRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(EndPoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }
}