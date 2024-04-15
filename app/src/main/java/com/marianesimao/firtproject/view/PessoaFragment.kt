package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.marianesimao.firtproject.databinding.FragmentPessoaBinding
import com.marianesimao.firtproject.service.model.Pessoa
import com.marianesimao.firtproject.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private  var _binding: FragmentPessoaBinding? = null
    private  val binding: FragmentPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()
            var sexo = binding.edtGenero.editableText.toString()
            var faixaEtaria = ""
            if (nome != ""&& anoNascimento != ""){

                binding.tvNome.text = "nome: $nome"
                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()
                binding.tvIdade.text = "idade: $idade"

                if (idade <= 12) {
                    faixaEtaria = "Infantil"
                } else if (idade <= 17) {
                    faixaEtaria = "Adolescente"
                } else if (idade <= 64) {
                    faixaEtaria = "Adulto"
                } else if (idade <= 115) {
                    faixaEtaria = "Idoso"
                } else {
                    Toast.makeText(requireContext(), "Digite sua idade correta, esses dados são invalidos!",
                        Toast.LENGTH_LONG).show()
                }

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaEtaria = faixaEtaria
                )

                viewModel.incert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }
}