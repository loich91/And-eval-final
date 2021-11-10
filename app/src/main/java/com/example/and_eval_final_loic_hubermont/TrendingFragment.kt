package com.example.and_eval_final_loic_hubermont

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.and_eval_final_loic_hubermont.callApi.ConnexionMovieImpl
import com.example.and_eval_final_loic_hubermont.databinding.FragmentTrendingBinding


class TrendingFragment : Fragment() {
   private lateinit var binding: FragmentTrendingBinding
    private val conn by lazy { ConnexionMovieImpl() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}