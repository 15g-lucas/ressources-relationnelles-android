package com.cesi.ressourcesrelationnelles.ui.screen.createpost.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun DropdownChecklist(
    options: List<String>,
    selectedOptions: MutableList<String>,
){
//    Column(
//        Modifier
//            .alpha(0.9f)
//            .width(182.dp)
//    ) {
        options.forEach { option ->
            DropdownCheckItem(
                option = option,
                isSelected = selectedOptions.contains(option),
                onOptionSelected = { selectedOption, isChecked ->
                    if (isChecked) {
                        selectedOptions.add(selectedOption)
                    } else {
                        selectedOptions.remove(selectedOption)
                    }
                }
            )
        }
//    }
}