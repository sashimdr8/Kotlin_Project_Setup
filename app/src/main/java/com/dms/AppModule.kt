package com.dms

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.dms.data.AppData
import com.dms.data.local.LocalRepo
import com.dms.data.local.Prefs
import com.dms.data.remote.Api
import com.dms.data.remote.RemoteRepo
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by brain on 12/5/17.
 */
@Module
class AppModule(private var app: Context) {

    @Provides
    internal fun provideContext(): Context = app

    @Provides
    @Singleton
    internal fun gson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRemoteRepo(api: Api, gson: Gson): RemoteRepo {
        return RemoteRepo(api, gson)
    }


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("http://app.tracesell.com/api/")
//                .addConverterFactory(BaseResponseConverter())
                //                .addConverterFactory(ScalarsConverterFactory.create())//To convert primitive and boxed types
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideData(localRepo: LocalRepo, remoteRepo: RemoteRepo): AppData {
        return AppData(localRepo, remoteRepo)
    }

    @Provides
    @Singleton
    fun providePrefs(gson: Gson): Prefs {
        return Prefs(app, gson)
    }
}

