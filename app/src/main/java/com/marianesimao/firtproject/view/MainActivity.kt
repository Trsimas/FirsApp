package com.marianesimao.firtproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marianesimao.firtproject.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private  var _binding: ActivityMainBinding? = null
    private  val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEnviar.setOnClickListener {
//            var email = binding.edtEmail.editableText.toString()
//            if (email.contains("@") && email.substringAfter("@").contains(".com"))
//            {
//                binding.tvEmail.text = "E-mail: ${email}"
//            }
//            else {
//                binding.tvEmail.text = "O E-mail está incorreto!"
//            }
//            var telefone = binding.edtTel.editableText.toString()
//            if (telefone.length == 11) {
//                binding.tvTelefone.text = "Telefone: ${telefone}"
//            }
//            else {
//                binding.tvTelefone.text = "Telefone incorreto!"
//            }
//        }
    }
}