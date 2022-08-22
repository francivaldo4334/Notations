package br.com.francivaldo.notations.presentation.view.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.francivaldo.notations.presentation.Constants
//card de adicao de nova nota
@Composable
fun DialogDeleteNota(open:Boolean,onDismissRequest:()-> Unit,id:Int){
    if(open)
        Dialog(onDismissRequest = onDismissRequest) {
            Card{
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    //titulo
                    Text(text = "Realmente deseja Excluir esta nota?")
                    Spacer(modifier = Modifier.size(16.dp))
                    //bottao de confirmar
                    Row {
                        Button(
                            onClick = {
                                onDismissRequest.invoke()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 8.dp)
                        ) {
                            Text(text = "Concelar")
                        }
                        Button(
                            onClick = {
                                //deletar item em banco de dados
                                Constants.getViewModel().deleteNota(id)
                                //fechar
                                onDismissRequest.invoke()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp)
                        ) {
                            Text(text = "Confirmar")
                        }
                    }
                }
            }
        }
}