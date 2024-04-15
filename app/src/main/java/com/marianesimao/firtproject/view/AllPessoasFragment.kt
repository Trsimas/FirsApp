package com.marianesimao.firtproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marianesimao.firtproject.R
import com.marianesimao.firtproject.databinding.FragmentAllPessoasBinding
import com.marianesimao.firtproject.view.adapter.PessoaAdapter
import com.marianesimao.firtproject.viewmodel.AllPessoasViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllPessoasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllPessoasFragment : Fragment() {
    //chamar a view model
    private val viewModel: AllPessoasViewModel by viewModels()

    //chamar adapter
    private lateinit var adapter: PessoaAdapter

    //criar o binding
    private  var _binding: FragmentAllPessoasBinding? = null
    private  val binding: FragmentAllPessoasBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //quando clicar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value) {

        }

        //configura a recycler
        val recycler = binding.rvPessoa
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //observa para adcionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner) {
            adapter.updatePessoas(it)
        }

        //navegar para a tela de cadastro de pessoas
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.pessoaFragment)
        }

        //carregar as pessoas cadastradas
        viewModel.loadPessoas()
    }
}