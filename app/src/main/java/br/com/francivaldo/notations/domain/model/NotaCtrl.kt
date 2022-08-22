package br.com.francivaldo.notations.domain.model

import br.com.francivaldo.notations.data.model.NotaData
import br.com.francivaldo.notations.presentation.model.NotaUi

data class NotaCtrl(
    val id:Int,
    val title:String,
    val description:String,
)
fun NotaCtrl.toData() = NotaData(
    id = this.id,
    title = this.title,
    description = this.description
)
fun NotaCtrl.toUi() = NotaUi(
    id = this.id,
    title = this.title,
    description = this.description
)
