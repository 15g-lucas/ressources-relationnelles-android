package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto

@Composable
fun PostList(
    resources: List<ResourceDto>,
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            resources.forEach { resources ->
                item {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF1B1F23))

                    ) {
                        PostCard(resource = resources)

                    }
                }
            }
        }
    }
}

