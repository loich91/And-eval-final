package com.example.and_eval_final_loic_hubermont

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.and_eval_final_loic_hubermont.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}