package br.com.francivaldo.notations.data.model

import br.com.francivaldo.notations.data.room.entity.NotaEntity

data class NotaData(
    val id:Int,
    val title:String,
    val description:String,
)
fun NotaData.toEntity() = NotaEntity(
    title = this.title,
    description = this.description
)