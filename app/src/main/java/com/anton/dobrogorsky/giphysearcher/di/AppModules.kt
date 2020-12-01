package com.anton.dobrogorsky.giphysearcher.di

import android.app.Application
import com.anton.dobrogorsky.giphysearcher.BuildConfig
import com.anton.dobrogorsky.giphysearcher.R
import com.anton.dobrogorsky.giphysearcher.flow.search_gif.SearchGifViewModel
import com.anton.dobrogorsky.giphysearcher.service.giphy.Giphy
import com.anton.dobrogorsky.giphysearcher.service.giphy.GiphyConfigurator
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.TrendingApi
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.SearchApi
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

    val viewModel = module {
        viewModel { SearchGifViewModel(giphy = get()) }
    }

    val giphy = module {
        single { provideGiphyRetrofit() }
        single { provideGiphyConfigurator() }
        single { provideSearchApi(retrofit = get()) }
        single { provideRandomApi(retrofit = get()) }
        single { provideGiphy(configurator = get(), searchApi = get(), trendingApi = get()) }
    }

    val glide = module {
        single { provideRequestOptions() }
        single { provideRequestManager(application = androidApplication(), requestOptions = get()) }
    }

    fun provideRequestManager(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    fun provideRequestOptions(): RequestOptions {
        return RequestOptions()
            .fitCenter()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerInside()
            .placeholder(R.drawable.ic_load)
            .error(R.drawable.ic_error)
    }

    fun provideGiphyRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.GIPHY_BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideGiphyConfigurator(): GiphyConfigurator {
        return GiphyConfigurator(BuildConfig.GIPHY_API_KEY, "en")
    }

    fun provideGiphy(
        configurator: GiphyConfigurator,
        searchApi: SearchApi,
        trendingApi: TrendingApi
    ): Giphy {
        return Giphy(configurator, searchApi, trendingApi)
    }

    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

    fun provideRandomApi(retrofit: Retrofit): TrendingApi = retrofit.create(TrendingApi::class.java)

}