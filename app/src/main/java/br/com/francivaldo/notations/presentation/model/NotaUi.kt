package br.com.francivaldo.notations.presentation.model

import br.com.francivaldo.notations.domain.model.NotaCtrl

data class NotaUi(
    val id:Int = 0,
    val title:String = "",
    val description:String = ""
)
fun NotaUi.toCtrl() = NotaCtrl(
    id = this.id,
    title = this.title,
    description = this.description
)