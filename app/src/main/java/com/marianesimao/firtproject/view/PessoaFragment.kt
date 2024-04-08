package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.marianesimao.firtproject.databinding.FragmentCalculoBinding
import com.marianesimao.firtproject.service.model.Pessoa
import com.marianesimao.firtproject.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

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
            val anoNascimento = binding.edtanoNascimento.editableText.toString()
            if (nome != ""&& anoNascimento != ""){

                binding.TVnome.text = "nome: $nome"
                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()
                binding.tvIdade.text = "idade: $idade"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade
                )

                viewModel.incert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtanoNascimento.editableText.clear()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }
}