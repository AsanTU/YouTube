package mbk.io.youtubeapi.di

import mbk.io.youtubeapi.ui.playlistItems.VideoViewModel
import mbk.io.youtubeapi.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }

    viewModel {
        VideoViewModel(get())
    }
}