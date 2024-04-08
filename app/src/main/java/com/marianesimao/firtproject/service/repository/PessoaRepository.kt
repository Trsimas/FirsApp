package com.marianesimao.firtproject.service.repository

import android.content.Context
import com.marianesimao.firtproject.service.model.Pessoa
import com.marianesimao.firtproject.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private  val firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun incertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa)
    }

    suspend fun getPessoa(id: Int){
        firstAppDb.getPessoa(id)
    }

    suspend fun getPessoas(): List<Pessoa> {
        return firstAppDb.getAll()
    }

    suspend fun  updatePessoa(pessoa:Pessoa) {
        firstAppDb.update(pessoa)
    }

    suspend fun deletePessoa(id: Int) {
        firstAppDb.delete(id)
    }
}