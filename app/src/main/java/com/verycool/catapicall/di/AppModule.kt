package com.verycool.catapicall.di

import com.verycool.catapicall.data.interceptor.ApiInterceptor
import com.verycool.catapicall.data.service.ApiService
import com.verycool.catapicall.data.service.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        client:OkHttpClient
    ):ApiService = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesOkHttp(
        interceptor: ApiInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ):OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideLoginInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesDispatcher() : CoroutineDispatcher = Dispatchers.IO
}