package roiattia.com.mymovieskotlin.ui.movies_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_movie.view.*
import roiattia.com.mymovieskotlin.R
import roiattia.com.mymovieskotlin.model.Movie
import roiattia.com.mymovieskotlin.utils.Constants.Companion.MOVIES_BASE_URL_POSTER_PATH
import roiattia.com.mymovieskotlin.utils.Constants.Companion.MOVIES_POSTER_SIZE

class MoviesAdapter(private val context: Context, private val moviesData: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder) {
            tvMovieTitle.text = moviesData[position].originalTitle
            Glide.with(context)
                .load(MOVIES_BASE_URL_POSTER_PATH + MOVIES_POSTER_SIZE + moviesData[position].posterPath)
                .into(tvMoviePoster)
        }
    }

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvMovieTitle: TextView = view.findViewById(R.id.tvMovieTitle)
        val tvMoviePoster: ImageView = view.findViewById(R.id.ivMoviePoster)
    }

}
