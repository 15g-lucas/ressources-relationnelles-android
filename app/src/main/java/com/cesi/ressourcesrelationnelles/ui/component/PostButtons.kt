package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InteractiveButton(modifier: Modifier = Modifier)
{
    Row(
        modifier = modifier
    ) {
        //Exploited
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Default.VolunteerActivism, contentDescription = "resource exploited")
        }
        //Likes
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "resource liked")
        }
        //Saves
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Default.Bookmark, contentDescription = "resource saved")
        }
        //Shares
        IconButton(
            modifier = Modifier
                .padding(end = 0.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Default.Repeat, contentDescription = "resource shared")
        }

    }
}