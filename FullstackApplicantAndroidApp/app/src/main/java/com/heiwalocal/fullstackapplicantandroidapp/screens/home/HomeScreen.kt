package com.heiwalocal.fullstackapplicantandroidapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.components.AppBottomNavBar
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.components.HomeTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.LargeVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.SmallVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.SearchInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    var searchedText by remember { mutableStateOf("") }

    val lastAddedVacancies = viewModel.lastAddedVacancies.observeAsState().value
    val recommendedVacancies = viewModel.recommendedVacancies.observeAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.getRecommendedVacancies()
        viewModel.getLastAddedVacancies()
    }

    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        bottomBar = {
            AppBottomNavBar(navController)
        },
        topBar = {
            HomeTopBar()
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
                onNextClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("keywords", searchedText)
                    navController.navigate("search")
                }
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Актуальное для вас",
                style = ExtendedTheme.typography.h2
            )
            if (recommendedVacancies != null && recommendedVacancies.isNotEmpty()) {
                LazyRow(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(recommendedVacancies) { it ->
                        LargeVacancyCard(
                            onClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "clicked_vacancy",
                                    it.id
                                )
                                navController.navigate("vacancydetail")
                            },
                            organizationName = it.organizationName.toString(),
                            organizationLogoUrl = it.organizationLogoUrl.toString(),
                            jobTitle = it.jobTitle.toString(),
                            salary = it.salary.toString(),
                            address = it.address.toString(),
                        )
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(150.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Пока что тут пусто :(",
                        style = ExtendedTheme.typography.h3,
                        color = ExtendedTheme.colors.hint
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Последние добавленные",
                style = ExtendedTheme.typography.h2
            )
            if (lastAddedVacancies != null) {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxSize()
                    ,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(lastAddedVacancies) { it ->
                        SmallVacancyCard(
                            onClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "clicked_vacancy",
                                    it.id
                                )
                                navController.navigate("vacancydetail")
                            },
                            organizationName = it.organizationName.toString(),
                            organizationLogoUrl = it.organizationLogoUrl.toString(),
                            jobTitle = it.jobTitle.toString(),
                            salary = it.salary.toString(),
                            address = it.address.toString(),
                        )
                    }
                }
            }
        }
    }
}