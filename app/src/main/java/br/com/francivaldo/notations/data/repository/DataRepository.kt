package br.com.francivaldo.notations.data.repository

import br.com.francivaldo.notations.data.model.NotaData
import br.com.francivaldo.notations.data.model.toEntity
import br.com.francivaldo.notations.data.room.dao.NotaDao
import br.com.francivaldo.notations.data.room.entity.toData

class DataRepository(
    private val notaDao:NotaDao
) : DataRepositoryinterface{
    override suspend fun setNota(nota: NotaData) {
        notaDao.setNota(nota.toEntity())
    }

    override suspend fun getNota(id: Int): NotaData {
        return notaDao.getNota(id).toData()
    }

    override suspend fun listNota(): List<NotaData> {
        return notaDao.listNota().map { it.toData() }
    }

    override suspend fun deleteNota(id: Int) {
        notaDao.deleteNota(id)
    }

}
interface DataRepositoryinterface{
    suspend fun setNota(nota:NotaData)
    suspend fun getNota(id:Int):NotaData
    suspend fun listNota():List<NotaData>
    suspend fun deleteNota(id:Int)
}