package com.example.moviedb.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.npoint.io/"
const val POST_FIX = "4b228f490cc6b3c32a7c"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface MovieApiService{
    @GET(POST_FIX)
    suspend fun getMovie() : List<Movie>
}

object MovieApi{
    val retrofitService: MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}