package com.marianesimao.firtproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.marianesimao.firtproject.service.model.Pessoa
import com.marianesimao.firtproject.service.repository.PessoaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PessoaViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PessoaRepository(application)

    fun incert(pessoa: Pessoa) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.incertPessoa(pessoa)
        }
    }
    fun  getPessoa(id: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.getPessoa(id)
        }
    }
    fun update(pessoa: Pessoa) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.updatePessoa(pessoa)
        }
    }
    fun delete(id: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.deletePessoa(id)
        }
    }
}