package com.cesi.ressourcesrelationnelles.ui.screen.createpost.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun DropdownCheckItem(
    option: String,
    isSelected: Boolean,
    onOptionSelected: (String, Boolean) -> Unit
) {
    Row(
        Modifier.fillMaxWidth()
            .height(40.dp)
            .toggleable(
                value = isSelected,
                onValueChange = { isChecked ->
                    onOptionSelected(option, isChecked) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = option)
        Checkbox(
            modifier = Modifier.padding(start = 16.dp),
            checked = isSelected,
            onCheckedChange = { isChecked ->
                onOptionSelected(option, isChecked)
            }
        )
    }

}