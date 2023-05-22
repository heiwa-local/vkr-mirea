package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tabs.Tabs

@Composable
fun VacancyInfoTabs(
    modifier: Modifier = Modifier,
    description: String,
    organizationDescription: String
) {
    var selectedTab by remember { mutableStateOf("Описание") }

    Tabs(
        modifier = modifier
            .padding(top = 16.dp),
        selected = selectedTab,
        onSelectedChange = { selectedTab = it },
        items = arrayOf("Описание", "О компании")
    )
    when (selectedTab) {
        "Описание" -> {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = description,
            )
        }
        "О компании" -> {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = organizationDescription,
            )
        }
    }
}