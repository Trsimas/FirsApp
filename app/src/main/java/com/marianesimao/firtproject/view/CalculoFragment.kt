package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marianesimao.firtproject.R
import com.marianesimao.firtproject.databinding.ActivityMainBinding
import com.marianesimao.firtproject.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {

    private  var _binding: FragmentCalculoBinding? = null
    private  val binding: FragmentCalculoBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnenviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            binding.TVnome.text = "nome: $nome"


            val anoNascimento = binding.edtanoNascimento.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            val idade = anoAtual - anoNascimento.toInt()

            binding.tvIdade.text = "idade: $idade"
        }
    }
}