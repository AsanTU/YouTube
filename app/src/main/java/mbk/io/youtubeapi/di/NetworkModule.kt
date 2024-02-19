package mbk.io.youtubeapi.di

import org.koin.dsl.module


val networkModule = module {
    single {
        provideRetrofit(get())
    }

    single {
        provideOkHttpClient(get())
    }

    single {
        provideInterceptor()
    }

    single {
        provideCartoonApiService(get())
    }
}
