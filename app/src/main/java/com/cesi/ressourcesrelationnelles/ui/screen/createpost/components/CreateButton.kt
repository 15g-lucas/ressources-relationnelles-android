package com.cesi.ressourcesrelationnelles.ui.screen.createpost.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@Composable
fun CreateButton(
    text: String,
    onClick: () -> Unit,
    icon: ImageVector,
//    enabled: Boolean
) {
    Button(
        modifier = Modifier.size(160.dp, 48.dp),
        onClick = { onClick() },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
        ),
//        enabled = enabled
    ) {
        Icon(
            icon,
            contentDescription = text,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            fontFamily = roboto,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            softWrap = false,
            maxLines = 1
        )
    }

}