package com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LargeVacancyCard(
    modifier: Modifier = Modifier,
    organizationName: String,
    jobTitle: String,
    salary: String,
    address: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .width(260.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column{
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                ExtendedTheme.colors.largeButtonBackground
                            ),
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(4.dp),
                            imageVector = Icons.Default.Group,
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = organizationName,
                        style = ExtendedTheme.typography.body2,
                        color = ExtendedTheme.colors.hint
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = jobTitle,
                style = ExtendedTheme.typography.h3,
                color = ExtendedTheme.colors.text
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = salary,
                    style = ExtendedTheme.typography.h4,
                    color = ExtendedTheme.colors.text
                )
                Text(
                    text = address,
                    style = ExtendedTheme.typography.body2,
                    color = ExtendedTheme.colors.hint
                )
            }
        }
    }
}