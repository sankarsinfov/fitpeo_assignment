package comp.fitpeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import comp.fitpeo.databinding.ActivityDetailPageBinding
import comp.fitpeo.databinding.ActivityMainBinding

class DetailPage : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //get data from intent
        val intent = intent
        val title = intent.getStringExtra("title")
        val url = intent.getStringExtra("url")

        Picasso.with(this).load(url).into(binding.image)
        binding.txtTitle.text=title
    }
}