package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.data.model.Resource


@Composable
fun PostCard(
    resource: Resource
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        PostHeader(resource)
        PostContent(resource)
    }
}

@Preview
@Composable
fun PostCardPreview()
{
    val resource = Resource(
        author = "Michelle saucisse",
        title = "toto",
        description = "lorem ipsum",
        url = "http://toto.fr",
        visibility = 0,
        createdAt = "14h",
        updatedAt = ""
    )
    PostCard(resource = resource)
}





