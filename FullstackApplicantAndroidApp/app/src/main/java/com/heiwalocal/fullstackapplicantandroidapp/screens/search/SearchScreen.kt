package com.heiwalocal.fullstackapplicantandroidapp.screens.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.components.AppBottomNavBar
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.components.SearchTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.SmallVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.SearchInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.modalbottomsheets.SearchFilterModalBottomSheet
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchViewModel
) {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    var searchedText by remember { mutableStateOf(navController.previousBackStackEntry?.savedStateHandle?.get<String>("keywords").toString()) }

    val vacancies = viewModel.vacancy.observeAsState(initial = null).value
    val directions = viewModel.directions.observeAsState(initial = null).value

    LaunchedEffect(Unit) {
        viewModel.getVacanciesByKeywords(
            keywords = searchedText,
            type = null,
            salary = null,
            tags = null
        )
        viewModel.getDirections()
    }
    val coroutineScope = rememberCoroutineScope()
    SearchFilterModalBottomSheet(
        sheetState = bottomSheetState,
        directions = directions,
        onConfirmClick = {
            var typeId =""

            directions?.map { direction ->
                if (direction.name == it["type"]) {
                    typeId = direction.id
                }
            }
            viewModel.getVacanciesByKeywords(
                keywords = searchedText,
                type = typeId,
                salary = it["salary"],
                tags = it["tags"]
            )
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        }
    ) {
        Scaffold(
            backgroundColor = ExtendedTheme.colors.screenBackground,
            bottomBar = {
                AppBottomNavBar(
                    navController = navController
                )
            },
            topBar = {
                SearchTopBar(
                    navController = navController
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SearchInputLine(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        text = searchedText,
                        onValueChange = { searchedText = it },
                        onNextClick = {
                            viewModel.getVacanciesByKeywords(
                                keywords = searchedText,
                                type = null,
                                salary = null,
                                tags = null
                            )
                        }
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .fillMaxWidth()
                            .background(
                                ExtendedTheme.colors.largeButtonBackground
                            )
                    ) {
                        IconButton(
                            modifier = Modifier
                                .padding(4.dp)
                                .align(Alignment.Center),
                            onClick = {
                                coroutineScope.launch {
                                    bottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
//                                    bottomSheetState.show()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Text(text = "Найдено вакансий: ")
                    Text(text = vacancies?.size.toString())
                }
                if (vacancies != null) {
                    Log.e("bbbb", "hbcewer")
                    LazyColumn(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(vacancies) { it ->
                            SmallVacancyCard(
                                onClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set("clicked_vacancy", it.id)
                                    navController.navigate("vacancydetail")
                                },
                                organizationName = it.organizationName.toString(),
                                organizationLogoUrl = it.organizationLogoUrl.toString(),
                                jobTitle = it.jobTitle.toString(),
                                salary = "${it.salary.toString()} руб/мес ",
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
                            text = "Ничего не нашлось :(",
                            style = ExtendedTheme.typography.h3,
                            color = ExtendedTheme.colors.hint
                        )
                    }
                }
            }
        }
    }
}