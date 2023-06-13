package com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallResumeCard(
    modifier: Modifier = Modifier,
    background: Color = ExtendedTheme.colors.largeButtonContent,
    content: Color = ExtendedTheme.colors.largeButtonContent,
    jobTitle: String,
    salary: String,
    datetime: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .width(260.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        onClick = onClick,
        backgroundColor = background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = jobTitle,
                style = ExtendedTheme.typography.h3,
                color = content,
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${salary.toDouble().toInt()} руб/мес",
                    style = ExtendedTheme.typography.h3,
                    color = content
                )
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    text = datetime,
                    style = ExtendedTheme.typography.body2,
                    color = content
                )
            }
        }
    }
}