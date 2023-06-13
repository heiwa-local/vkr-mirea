package com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MediumResumeCard(
    modifier: Modifier = Modifier,
    jobTitle: String,
    salary: String,
    datetime: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = jobTitle,
                    style = ExtendedTheme.typography.h3,
                    color = ExtendedTheme.colors.text
                )

                Text(
                    text = "${salary.toDouble().toInt()} руб/мес",
                    style = ExtendedTheme.typography.h3,
                    color = ExtendedTheme.colors.text
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Дата создания: $datetime",
                style = ExtendedTheme.typography.body2,
                color = ExtendedTheme.colors.hint
            )
        }
    }
}