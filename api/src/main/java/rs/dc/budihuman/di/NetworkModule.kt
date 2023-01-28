package rs.dc.budihuman.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import rs.dc.budihuman.api.BeHumanService
import rs.inverse.behuman.api.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {
    companion object {
        private const val TIMEOUT = 30L
    }

    @Provides
    @Singleton
    @BaseUrlString
    fun provideBaseUrl(): String {
        return  BuildConfig.BASE_URL
    }

    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024L // 10 MB
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .dispatcher(Dispatcher())
            .cache(cache)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, @BaseUrlString baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): BeHumanService {
        return retrofit.create(BeHumanService::class.java)
    }

}