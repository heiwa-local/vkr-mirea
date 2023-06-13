package com.heiwalocal.fullstackapplicantandroidapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    var loading by remember { mutableStateOf(false) }

    var searchedText by remember { mutableStateOf("") }

    val lastAddedVacancies = viewModel.lastAddedVacancies.observeAsState().value
    val recommendedVacancies = viewModel.recommendedVacancies.observeAsState().value

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            loading = true
            viewModel.getRecommendedVacancies()
            viewModel.getLastAddedVacancies()
            loading = false
        }
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
        if (loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = ExtendedTheme.colors.largeButtonBackground
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
            ) {
                SearchInputLine(
                    text = searchedText,
                    onValueChange = { searchedText = it },
                    onNextClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "keywords",
                            searchedText
                        )
                        navController.navigate("search")
                    }
                )
                if (lastAddedVacancies != null) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = "Актуальное для вас",
                                    style = ExtendedTheme.typography.h2
                                )
                                if (recommendedVacancies != null && recommendedVacancies.isNotEmpty()) {
                                    LazyRow(
                                        modifier = Modifier.padding(top = 16.dp),
                                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    ) {
                                        items(recommendedVacancies) {
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
                            }
                        }
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
}