package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun VacancyInfoBaseInfoView(
    modifier: Modifier = Modifier,
    jobTitle: String,
    grade: String,
    organizationName: String,
    address: String,
    employment: String,
    salary: String,
    direction: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = jobTitle,
            style = ExtendedTheme.typography.h2
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = grade,
                style = ExtendedTheme.typography.h3
            )
            Text(
                text = direction,
                color = ExtendedTheme.colors.hint
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp),
        ) {
            Text(
                text = organizationName,
                style = ExtendedTheme.typography.h3
            )
            Text(
                text = " – ",
                style = ExtendedTheme.typography.h3
            )
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = null
            )
            Text(
                text = address,
                color = ExtendedTheme.colors.hint
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Timer,
                    contentDescription = null
                )
                Text(
                    text = employment
                )
            }
            Text(
                text = "$salary руб/мес",
                style = ExtendedTheme.typography.h3
            )
        }
    }
}