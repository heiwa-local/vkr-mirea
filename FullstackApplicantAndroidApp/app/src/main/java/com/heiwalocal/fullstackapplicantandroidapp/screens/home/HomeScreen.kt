package com.heiwalocal.fullstackapplicantandroidapp.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.LargeVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.SmallVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.SearchInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun HomeScreen(

) {
    var searchedText by remember { mutableStateOf("") }
    val recommendedVacancies = listOf("1", "2", "3")
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(16.dp),
                backgroundColor = ExtendedTheme.colors.screenBackground,
                contentColor = ExtendedTheme.colors.text,
                elevation = 0.dp
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "FullStack 👋🏻",
                        style = ExtendedTheme.typography.h1
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SearchInputLine(
                text = searchedText,
                onValueChange = {searchedText = it},
                onNextClick = {}
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Актуальное для вас",
                style = ExtendedTheme.typography.h2
            )
            LazyRow(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                items(recommendedVacancies){it ->
                    LargeVacancyCard(
                        onClick = {},
                        organizationName = "Google",
                        jobTitle = "Lead Product Manager",
                        salary = "$2500/мес",
                        address = " Торонто, Канада",
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Последние добавленные",
                style = ExtendedTheme.typography.h2
            )
            LazyColumn(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(recommendedVacancies) {it ->
                    SmallVacancyCard(
                        onClick = {},
                        organizationName = "Google",
                        jobTitle = "Lead Product Manager",
                        salary = "$2500/мес",
                        address = " Торонто, Канада",
                    )
                }
            }
        }
    }
}