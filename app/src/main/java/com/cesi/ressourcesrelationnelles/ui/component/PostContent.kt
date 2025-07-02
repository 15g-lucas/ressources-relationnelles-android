package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.data.model.Resource

@Composable
fun PostContent(resource : Resource)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = resource.title
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = resource.description
        )
        if (resource.url != "")
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(350.dp)
                    .clip(RoundedCornerShape(15.dp)),
            )
            {
                AsyncImage(
                    model = resource.url,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                InteractiveButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .background(Color.White))
            }
        }
    }
}