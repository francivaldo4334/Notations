package br.com.francivaldo.notations.domain.repository

import android.app.Application
import br.com.francivaldo.notations.data.model.toCtrl
import br.com.francivaldo.notations.data.repository.DataRepository
import br.com.francivaldo.notations.data.room.AppRoomDatabase
import br.com.francivaldo.notations.domain.model.NotaCtrl
import br.com.francivaldo.notations.domain.model.toData

class CtrlRepository(application:Application) : CtrlRepositoryInterface{
    val dataRepository:DataRepository
    init {
        val roomDatabase = AppRoomDatabase.getInstance(application)
        dataRepository = DataRepository(roomDatabase.getNotaDao())
    }

    override suspend fun setNota(nota: NotaCtrl) {
        dataRepository.setNota(nota.toData())
    }

    override suspend fun getNota(id: Int): NotaCtrl {
        return dataRepository.getNota(id).toCtrl()
    }

    override suspend fun listNota(): List<NotaCtrl> {
        return dataRepository.listNota().map { it.toCtrl() }
    }

    override suspend fun deleteNota(id: Int) {
        dataRepository.deleteNota(id)
    }
}
interface CtrlRepositoryInterface{
    suspend fun setNota(nota:NotaCtrl)
    suspend fun getNota(id:Int):NotaCtrl
    suspend fun listNota():List<NotaCtrl>
    suspend fun deleteNota(id:Int)
}
