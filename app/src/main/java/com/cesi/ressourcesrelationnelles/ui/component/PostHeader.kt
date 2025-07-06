package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto

@Composable
fun PostHeader(resource : ResourceDto) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(55.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp),
            text = resource.author
        )

        Text(
            modifier = Modifier,
            text = resource.createdAt,
            textAlign = TextAlign.End,
            color =  colorScheme.onSurface.copy(alpha = 0.38f)
        )
    }
}