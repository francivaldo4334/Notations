package br.com.francivaldo.notations.presentation.view.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

//card de adicao de nova nota
@Composable
fun DialogAddNota(open:Boolean,onDismissRequest:()-> Unit){
    var valueTitle by remember{
        mutableStateOf("")
    }
    var valueDescription by remember{
        mutableStateOf("")
    }
    if(open)
        Dialog(onDismissRequest = onDismissRequest) {
            Card{
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    //titulo
                    Text(text = "Titulo:")
                    TextField(
                        value = valueTitle,
                        onValueChange = {valueTitle = it},
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    //descricao
                    Text(text = "Descricao:")
                    TextField(
                        value = valueDescription,
                        onValueChange = {valueDescription = it},
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    //bottao de confirmar
                    Button(
                        onClick = {
                              //adicionar en banco de dados

                              //fechar
                              onDismissRequest.invoke()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "Adicionar nata")
                    }
                }
            }
        }
}