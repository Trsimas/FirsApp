package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marianesimao.firtproject.R
import com.marianesimao.firtproject.databinding.FragmentCalculoBinding
import com.marianesimao.firtproject.databinding.FragmentVerificaBinding

class VerificaFragment : Fragment() {

    private  var _binding: FragmentVerificaBinding? = null
    private  val binding: FragmentVerificaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerificaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var email = binding.edtEmail.editableText.toString()
            if (email.contains("@") && email.substringAfter("@").contains(".com"))
            {
                binding.tvEmail.text = "E-mail: ${email}"
            }
            else {
                binding.tvEmail.text = "O E-mail está incorreto!"
            }
            var telefone = binding.edtTel.editableText.toString()
            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }
            else {
                binding.tvTelefone.text = "Telefone incorreto!"
            }
        }
    }
}