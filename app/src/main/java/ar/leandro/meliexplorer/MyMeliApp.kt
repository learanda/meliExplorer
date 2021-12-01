package ar.leandro.meliexplorer

import android.app.Application
import ar.leandro.meliexplorer.data.MeliApiRepoImpl
import ar.leandro.meliexplorer.domain.MeliRepo
import ar.leandro.meliexplorer.ui.viewmodels.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class MyMeliApp : Application() {
    private val appModule = module {
        single<MeliRepo> { MeliApiRepoImpl() }
        viewModel { SearchViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Describe the bug
            // Latest koin version produces NoSuchMethodErrors at runtime when using kotlin 1.6.0-RC
            // Set Koin logger to level Error, as a workaround for the time being
            // https://github.com/InsertKoinIO/koin/issues/1188
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyMeliApp)
            modules(appModule)
        }
    }
}