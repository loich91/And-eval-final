package com.example.and_eval_final_loic_hubermont

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.and_eval_final_loic_hubermont.callApi.ConnexionMovieImpl

import com.example.and_eval_final_loic_hubermont.databinding.FragmentMovieBinding
import com.example.and_eval_final_loic_hubermont.model.ResultMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MovieFragment : Fragment(),MovieAdapter.OnMovieAdapterListener {
    private lateinit var binding: FragmentMovieBinding
    private val conn by lazy { ConnexionMovieImpl() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLoop.setOnClickListener {

            val textuser = binding.searchText.text

                setupData(textuser.toString())

        }
    }

    fun setupData(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = conn.getMovie(query)
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                        response.body()?.let { movieData->
                            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                            binding.recyclerView.adapter = movieData.resultMovies?.let { MovieAdapter(it,this@MovieFragment) }
                        }
                    }

                }
            }
        }

    override fun onMovieAdapterListener(movieData: ResultMovie) {
        val action = MovieFragmentDirections.actionMovieFragmentToDetailmovieFragment(movieData)
        findNavController().navigate(action)
    }

}
