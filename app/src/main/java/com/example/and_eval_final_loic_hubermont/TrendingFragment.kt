package com.example.and_eval_final_loic_hubermont

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.and_eval_final_loic_hubermont.callApi.ConnexionMovieImpl
import com.example.and_eval_final_loic_hubermont.databinding.FragmentTrendingBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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
    fun setupData(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = conn.getMtrending()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.INVALID_OFFSET,false)
                    /* je devais terminé l'adapter de la page trending*/
                }
            }
        }
    }
}