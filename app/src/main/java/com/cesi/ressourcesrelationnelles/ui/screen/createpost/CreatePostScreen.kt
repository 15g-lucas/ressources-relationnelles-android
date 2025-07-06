package com.cesi.ressourcesrelationnelles.ui.screen.createpost

import android.net.Uri
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.ButtonWithDropdown
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.CreateButton
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.components.DropdownChecklist

@Composable
fun CreatePost(
    selectedOptions: MutableList<String>,
    selectedMediaUri: MutableState<Uri?>,
    onDismiss: () -> Unit,
    onPublishClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textState = remember { mutableStateOf("") }
    val isMediaAdded: Boolean = selectedMediaUri.value != null
    val enabled: Boolean = textState.value.isNotBlank() || isMediaAdded

    val mediaPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        selectedMediaUri.value = uri
    }

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.White),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = onDismiss,
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }

            Button(
                onClick = {
                    onPublishClick()
                    textState.value = ""
                    selectedMediaUri.value = null
                    selectedOptions.clear()
                },
                enabled = enabled
            ) {
                Text("Publier")
            }
        }

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
                onClick = {  }
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
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .background(Color.White, RoundedCornerShape(12.dp))
                                .padding(12.dp)
                        ) {
                            if (textState.value.isEmpty()) {
                                Text("Ajouter votre texte ici", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                selectedMediaUri.value?.let { uri ->
                    if (uri.toString().endsWith(".mp4") || uri.toString().contains("video")) {
                        AndroidView(
                            factory = { context ->
                                VideoView(context).apply {
                                    setVideoURI(uri)
                                    start()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                    } else {
                        AsyncImage(
                            model = uri,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Row(
                    modifier = Modifier.padding(vertical = 20.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    CreateButton(
                        text = "Ajouter image",
                        onClick = {
                            mediaPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                        icon = Icons.Outlined.Image
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CreateButton(
                        text = "Ajouter vidéo",
                        onClick = {
                            mediaPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly)
                            )
                        },
                        icon = Icons.Outlined.Videocam
                    )
                }
            }
        }
    }
}
