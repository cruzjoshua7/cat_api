package com.verycool.catapicall.di

import com.verycool.catapicall.data.repositroy.CatsRepository
import com.verycool.catapicall.data.repositroy.CatsRepositoryImpl
import com.verycool.catapicall.data.service.ApiService
import com.verycool.catapicall.data.service.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer YOUR_API_KEY") // Modify as needed
            .build()
        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun providesService(
        client: OkHttpClient
    ): ApiService = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesOkhttp(
        interceptor: Interceptor
    ) : OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    @Singleton
    abstract fun bindRepository(
        catsRepositoryImpl : CatsRepositoryImpl
    ) : CatsRepository
}