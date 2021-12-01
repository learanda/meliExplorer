package ar.leandro.meliexplorer.domain

import android.app.Application
import ar.leandro.meliexplorer.data.MeliApiRepoImpl
import ar.leandro.meliexplorer.ui.viewmodels.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    private val appModule = module {
        single<MeliRepo> { MeliApiRepoImpl() }
        viewModel { SearchViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}