package br.com.francivaldo.notations.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.francivaldo.notations.presentation.Constants
import br.com.francivaldo.notations.presentation.model.NotaUi
import br.com.francivaldo.notations.presentation.view.ui.theme.NotationsTheme
import br.com.francivaldo.notations.presentation.view.widgets.DialogAddNota
import br.com.francivaldo.notations.presentation.view.widgets.LayoutNota
import br.com.francivaldo.notations.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializacao de ViewModel
        Constants.setViewModel(MainViewModel(this.application))
        Constants.getViewModel().listNota()
        setContent {
            NotationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //variaveis
                    var openDialog by remember {
                        mutableStateOf(false)
                    }
                    //layout
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ){
                        //List de lembretes
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .fillMaxSize()
                        ){
                            items(Constants.getViewModel().listNotaRespo){
                                LayoutNota(item = it)
                            }
                        }
                        //Bottao flutuante
                        FloatingActionButton(
                            onClick = {
                                      openDialog = true
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "icon Add")
                        }
                        //Dialogo de adicao
                        DialogAddNota(open = openDialog) {
                            openDialog = false
                        }
                    }
                }
            }
        }
    }
}