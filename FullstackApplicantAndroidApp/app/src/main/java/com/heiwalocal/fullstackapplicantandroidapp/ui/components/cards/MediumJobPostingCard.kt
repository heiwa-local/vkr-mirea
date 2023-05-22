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
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MediumJobPostingCard(
    modifier: Modifier = Modifier,
    organizationName: String,
    jobTitle: String,
    status: String,
    datetime: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
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
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = jobTitle,
                    style = ExtendedTheme.typography.h3,
                    color = ExtendedTheme.colors.text
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Статус: $status",
                        style = ExtendedTheme.typography.body2,
                        color = ExtendedTheme.colors.text
                    )
                    Text(
                        text = datetime,
                        style = ExtendedTheme.typography.body2,
                        color = ExtendedTheme.colors.hint
                    )
                }
            }
        }
    }

}