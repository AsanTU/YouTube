package mbk.io.youtubeapi.ui.playlistItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mbk.io.youtubeapi.data.model.BaseResponse
import mbk.io.youtubeapi.data.model.VideoModel
import mbk.io.youtubeapi.data.repository.YouTubeRepository
import mbk.io.youtubeapi.utils.Resource

class VideoViewModel(private val repository: YouTubeRepository) : ViewModel() {

    fun getPlaylistVideo(getId: String, listSize:Int): LiveData<Resource<List<VideoModel.Item>>> =
        repository.getPlaylistVideo(getId, listSize)

}