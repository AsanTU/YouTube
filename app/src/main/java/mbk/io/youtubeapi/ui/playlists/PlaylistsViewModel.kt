package mbk.io.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mbk.io.youtubeapi.data.model.BaseResponse
import mbk.io.youtubeapi.data.repository.YouTubeRepository
import mbk.io.youtubeapi.utils.Resource

class PlaylistsViewModel(private val repository: YouTubeRepository): ViewModel() {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = repository.getPlaylists()

}