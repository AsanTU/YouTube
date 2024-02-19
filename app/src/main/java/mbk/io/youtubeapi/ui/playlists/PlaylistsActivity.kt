package mbk.io.youtubeapi.ui.playlists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import mbk.io.youtubeapi.data.base.BaseActivity
import mbk.io.youtubeapi.data.model.BaseResponse
import mbk.io.youtubeapi.databinding.ActivityMainBinding
import mbk.io.youtubeapi.ui.playlistItems.PlaylistItemsActivity
import mbk.io.youtubeapi.ui.playlists.adapter.PlaylistsAdapter
import mbk.io.youtubeapi.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistsActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  viewModel:PlaylistsViewModel by viewModel()
    private lateinit var adapter: PlaylistsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getPlaylists().stateHandler(
            success = {
                adapter = PlaylistsAdapter(this::onClick)
                adapter.submitList(it)
                binding.recyclerView.adapter = adapter
            },
            state = {
                binding.progressBar.isVisible = it is Resource.Loading
            }
        )
    }


    private fun onClick(item: BaseResponse.Item) {
        val intent = Intent(this, PlaylistItemsActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("size", item.contentDetails.itemCount)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("description", item.snippet.description)
        startActivity(intent)
    }
}
