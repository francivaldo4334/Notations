package br.com.francivaldo.notations.presentation.view.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.notations.presentation.model.NotaUi

@Composable
fun LayoutNota(item:NotaUi){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(width = 1.dp, Color.Black.copy(alpha = 0.2f)),
                shape = RoundedCornerShape(20.dp)
            )
            .background(MaterialTheme.colors.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ){
            Text(text = "${item.id} - ${item.title}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "${item.description}", fontSize = 14.sp)
        }
    }
}