package comp.fitpeo.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import comp.fitpeo.DetailPage
import comp.fitpeo.databinding.PhotoLayoutBinding
import comp.fitpeo.model.AlpumItem

class photos: RecyclerView.Adapter<photos.ViewHolder>() {
    private var alpumList = ArrayList<AlpumItem>()
    //private lateinit var binding: PhotoLayoutBinding
    private var context: Context? = null
    fun setMovieList(alpumList: List<AlpumItem>, context1: Context) {
        this.alpumList = alpumList as ArrayList<AlpumItem>
        this.context=context1
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: PhotoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PhotoLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /*Picasso.get().load(alpumList.get(position).thumbnailUrl).into(holder.binding.image)*/
        Picasso.with(context).load(alpumList.get(position).thumbnailUrl).into(holder.binding.image)

        Log.d("dfjkuighufd",""+alpumList[position].title)
        holder.binding.txtTitle.text = alpumList[position].title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailPage::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("title", alpumList[position].title)
            intent.putExtra("url", alpumList[position].url)

            context?.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return alpumList.size
        {
        }
    }
}