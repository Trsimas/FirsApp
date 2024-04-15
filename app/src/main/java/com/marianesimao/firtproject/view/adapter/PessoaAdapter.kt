package com.marianesimao.firtproject.view.adapter

import android.telephony.TelephonyCallback.EmergencyNumberListListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marianesimao.firtproject.databinding.ListItemPessoaBinding
import com.marianesimao.firtproject.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit) :
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {
        private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString()
            binding.tvfaixaEtaria.text = pessoa.faixaEtaria

            if (pessoa.sexo == "masculino" || pessoa.sexo == "homem") {
                binding.imgMasc.visibility = View.VISIBLE
                binding.imgFem.visibility = View.GONE
            } else {
                binding.imgFem.visibility = View.VISIBLE
                binding.imgMasc.visibility = View.GONE
            }

            binding.root.setOnClickListener {
                clickListListener(pessoa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
return pessoaList.count()   }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    fun updatePessoas(list: List<Pessoa>) {
        pessoaList = list
        notifyDataSetChanged()
    }
}