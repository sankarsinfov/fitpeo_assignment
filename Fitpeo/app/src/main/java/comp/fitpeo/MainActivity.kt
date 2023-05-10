package comp.fitpeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import comp.fitpeo.adapter.photos
import comp.fitpeo.databinding.ActivityMainBinding
import comp.fitpeo.model.alpumViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: alpumViewModel
    private lateinit var movieAdapter : photos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[alpumViewModel::class.java]
        viewModel.getServices()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            Log.d("hjtgyfyfgt",""+movieList)
            movieAdapter.setMovieList(movieList,applicationContext)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = photos()
        binding.rcHomeList.apply {
            layoutManager = GridLayoutManager(applicationContext,1)
            adapter=movieAdapter
        }

    }

}