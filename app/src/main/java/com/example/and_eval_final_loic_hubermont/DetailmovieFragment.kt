package com.example.and_eval_final_loic_hubermont

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.and_eval_final_loic_hubermont.databinding.FragmentDetailmovieBinding
import com.squareup.picasso.Picasso

class DetailmovieFragment : Fragment() {
    private lateinit var binding: FragmentDetailmovieBinding
    private val args : DetailmovieFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailmovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/"+args.results.backdropPath)
            .into(binding.imageFilmBackground)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/"+args.results.posterPath)
            .into(binding.posterImage)
        binding.titleText.text = args.results.title
        binding.textDescription.text = args.results.overview

    }

}