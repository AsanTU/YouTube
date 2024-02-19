package mbk.io.youtubeapi.di

import mbk.io.youtubeapi.data.repository.YouTubeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single {
        YouTubeRepository(get())
    }
}