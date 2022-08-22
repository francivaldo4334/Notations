package br.com.francivaldo.notations.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nota")
data class NotaEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val description:String
)
