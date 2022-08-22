package br.com.francivaldo.notations.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.francivaldo.notations.domain.model.toUi
import br.com.francivaldo.notations.domain.repository.CtrlRepository
import br.com.francivaldo.notations.presentation.model.NotaUi
import br.com.francivaldo.notations.presentation.model.toCtrl
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : ViewModel(){
    var notaRespo by mutableStateOf(NotaUi())
    var listNotaRespo by mutableStateOf(listOf<NotaUi>())
    val ctrlRepository:CtrlRepository
    init {
        ctrlRepository = CtrlRepository(application)
    }
    fun getNota(id:Int){
        viewModelScope.launch {
            notaRespo = ctrlRepository.getNota(id).toUi()
        }
    }
    fun setNota(nota:NotaUi){
        viewModelScope.launch {
            ctrlRepository.setNota(nota.toCtrl())
        }
    }
    fun listNota(){
        viewModelScope.launch {
            listNotaRespo = ctrlRepository.listNota().map { it.toUi() }
        }
    }
    fun deleteNota(id:Int){
        viewModelScope.launch {
            ctrlRepository.deleteNota(id)
        }
    }
}