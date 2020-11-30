package com.anton.dobrogorsky.giphysearcher.di

import com.anton.dobrogorsky.giphysearcher.BuildConfig
import com.anton.dobrogorsky.giphysearcher.flow.search_gif.SearchGifViewModel
import com.anton.dobrogorsky.giphysearcher.service.giphy.Giphy
import com.anton.dobrogorsky.giphysearcher.service.giphy.GiphyConfigurator
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.SearchApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
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
        single { provideGiphy(configurator = get(), searchApi = get()) }
    }

    fun provideGiphyRetrofit():Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.GIPHY_BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideGiphyConfigurator(): GiphyConfigurator {
        return GiphyConfigurator(BuildConfig.GIPHY_API_KEY, "en")
    }

    fun provideGiphy(configurator: GiphyConfigurator, searchApi: SearchApi): Giphy {
        return Giphy(configurator, searchApi)
    }

    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

}