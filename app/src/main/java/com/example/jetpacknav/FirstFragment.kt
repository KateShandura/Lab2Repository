package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknav.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), AnimalAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var animals = ArrayList<Animal>()
    lateinit var adapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pig = Animal("Peppa", "Delicious Ukrainian lard", getString(R.string.urlPigPhoto), getString(R.string.urlLardPhoto), getString(R.string.lard_recipe))
        var cow = Animal("Sveta", "Beef steak", getString(R.string.urlCowPhoto), getString(R.string.urlBeefStake) , getString(R.string.beef_stake))
        var chicken = Animal("Liza", "Chicken curry", getString(R.string.urlChickenPhoto), getString(R.string.urlChickenCurry) ,getString(R.string.chicken_curry))

        animals.add(pig)
        animals.add(cow)
        animals.add(chicken)
        adapter = AnimalAdapter(this ,animals, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(position: Int) {
        val bundle = bundleOf(SecondFragment.numberInArray to position,
            SecondFragment.nameOfRecipe to animals.get(position).desc,
            SecondFragment.recipe to animals.get(position).recipe,
            SecondFragment.urlPhotoOfDish to animals.get(position).urlRecipePhoto)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }


}

