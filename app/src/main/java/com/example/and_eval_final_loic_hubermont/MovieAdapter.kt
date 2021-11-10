package com.example.and_eval_final_loic_hubermont

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.and_eval_final_loic_hubermont.databinding.MoviesearchCellBinding
import com.example.and_eval_final_loic_hubermont.model.ResultMovie
import com.squareup.picasso.Picasso


class MovieAdapter(val movieList:List<ResultMovie>,val listener:OnMovieAdapterListener):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var binding:MoviesearchCellBinding
    interface OnMovieAdapterListener {
        fun onMovieAdapterListener(movieData:ResultMovie)
    }
    class MovieViewHolder(val binding: MoviesearchCellBinding,val listener: OnMovieAdapterListener):RecyclerView.ViewHolder(binding.root) {
        fun bind(movieData:ResultMovie){
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+movieData.posterPath)
                .into(binding.imageMovie)
            binding.texttitle.text = movieData.title
            itemView.setOnClickListener {
                listener.onMovieAdapterListener(movieData)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding = MoviesearchCellBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return  movieList.size
    }

}
