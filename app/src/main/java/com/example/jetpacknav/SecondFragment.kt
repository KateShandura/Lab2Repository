package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.jetpacknav.databinding.FragmentFirstBinding
import com.example.jetpacknav.databinding.FragmentSecondBinding
import java.text.FieldPosition

class SecondFragment() : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val numberInArray = "number"
        const val nameOfRecipe = "name"
        const val recipe = "recipe"
        const val urlPhotoOfDish = "url"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(urlPhotoOfDish)).fitCenter().into(binding.photo)
        binding.tvNameRecipe.text = arguments?.getString(nameOfRecipe)
        binding.tvRecipe.text = arguments?.getString(recipe)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}