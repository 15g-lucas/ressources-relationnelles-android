package com.cesi.ressourcesrelationnelles.ui.screen.createpost

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.ButtonWithDropdown
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.CreateButton
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.DropdownChecklist

@Preview
@Composable
fun CreatePostScreen() {
    val selectedOptions = remember { mutableStateListOf<String>() }
    val isMediaAdded = false
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Button(
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .weight(0.5f)
                    .height(48.dp),
                enabled = false,
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    bottomStart = 32.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp
                ),
                contentPadding = PaddingValues(10.dp),
                onClick = {}
            ) {
                Text("Qui peut voir le post ?", softWrap = false)
            }
            ButtonWithDropdown(
                modifier = Modifier.weight(0.5f),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    bottomStart = 0.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp
                ),
                label = "Choisissez",
                icon = true,
                dropdownContent = {
                    DropdownChecklist(
                        options = listOf("Famille", "Amis", "Collègues", "Autre"),
                        selectedOptions = selectedOptions
                    )
                }
            )
        }
        Box(
            Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .heightIn(250.dp, 600.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
        ) {
            BasicTextField(
                modifier = Modifier
                    .heightIn(100.dp,300.dp)
                    .fillMaxSize()
                    .padding(16.dp),
                value = "Ajouter votre texte ici",
                onValueChange = {},
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 20.dp)
            ) {
                CreateButton(
                    text = "Ajouter image",
                    onClick = { },
                    icon = Icons.Outlined.Image
                )
                Spacer(modifier = Modifier.width(8.dp))
                CreateButton(
                    text = "Ajouter vidéo",
                    onClick = { },
                    icon = Icons.Outlined.Videocam
                )
            }
        }
    }
}

