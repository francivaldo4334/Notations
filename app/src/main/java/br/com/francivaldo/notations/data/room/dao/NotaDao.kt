package br.com.francivaldo.notations.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.francivaldo.notations.data.room.entity.NotaEntity

@Dao
interface NotaDao {
    @Insert
    suspend fun setNota(nota:NotaEntity)
    @Query("SELECT * FROM nota WHERE id = :id")
    suspend fun getNota(id:Int)
    @Query("SELECT * FROM nota")
    suspend fun listNota():List<NotaEntity>
    @Query("DELETE FROM nota WHERE id = :id")
    suspend fun deleteNota(id:Int)
}