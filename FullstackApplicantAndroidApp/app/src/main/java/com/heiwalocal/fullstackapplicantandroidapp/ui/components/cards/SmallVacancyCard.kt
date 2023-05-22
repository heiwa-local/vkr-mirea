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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.images.OrganizationLogoImage
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallVacancyCard(
    modifier: Modifier = Modifier,
    organizationName: String,
    organizationLogoUrl: String,
    jobTitle: String,
    salary: String,
    address: String,
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OrganizationLogoImage(
                    size = 60.dp,
                    url = organizationLogoUrl
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .width(40.dp),
                    text = organizationName,
                    maxLines = 1,
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
                    maxLines = 1,
                    color = ExtendedTheme.colors.text
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "$salary руб/мес",
                        style = ExtendedTheme.typography.h4,
                        maxLines = 1,
                        color = ExtendedTheme.colors.text
                    )
                    Text(
                        text = address,
                        style = ExtendedTheme.typography.body2,
                        maxLines = 1,
                        color = ExtendedTheme.colors.hint
                    )
                }
            }
        }
    }
}