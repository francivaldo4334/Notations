package br.com.francivaldo.notations.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.francivaldo.notations.data.model.NotaData

@Entity(tableName = "nota")
data class NotaEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val description:String
)
fun NotaEntity.toData() = NotaData(
    id = this.id,
    title = this.title,
    description = this.description
)
