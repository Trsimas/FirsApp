package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marianesimao.firtproject.R
import com.marianesimao.firtproject.databinding.FragmentCalculoBinding
import com.marianesimao.firtproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding? = null
    private  val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.BtnCalculo.setOnClickListener {
            findNavController().navigate(R.id.calculoFragment)
        }
        binding.BtnVerifica.setOnClickListener {
            findNavController().navigate(R.id.verificaFragment)
        }
    }
}