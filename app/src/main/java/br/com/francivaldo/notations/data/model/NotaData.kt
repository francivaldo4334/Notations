package br.com.francivaldo.notations.data.model

import br.com.francivaldo.notations.data.room.entity.NotaEntity
import br.com.francivaldo.notations.domain.model.NotaCtrl

data class NotaData(
    val id:Int,
    val title:String,
    val description:String,
)
fun NotaData.toEntity() = NotaEntity(
    id = this.id,
    title = this.title,
    description = this.description
)
fun NotaData.toCtrl() = NotaCtrl(
    id = this.id,
    title = this.title,
    description = this.description
)