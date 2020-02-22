package com.gojek.trendingrepos.di

import com.gojek.trendingrepos.data.api.HttpClient
import com.gojek.trendingrepos.data.api.LoggingInterceptor
import com.gojek.trendingrepos.data.api.TrendingRepoApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class FakeTrendingRepoApiModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = LoggingInterceptor.create()

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return HttpClient.setupOkhttpClient(httpLoggingInterceptor)
    }

    @Singleton
    @Provides
    fun provideStarWarsApi(retrofit: Retrofit): TrendingRepoApiService {
        return retrofit.create(TrendingRepoApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = "http://localhost:8080/"

}