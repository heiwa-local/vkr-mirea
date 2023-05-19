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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Filter
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.repositories.VacancyRepository
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.SmallVacancyCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.SearchInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.modalbottomsheets.SearchFilterModalBottomSheet
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags.ClickableTags
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel
) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    var searchedText by remember { mutableStateOf("") }

    val recommendedVacancies = listOf("1", "2", "3", "1", "2", "3")
    val coroutineScope = rememberCoroutineScope()

        Scaffold(
            backgroundColor = ExtendedTheme.colors.screenBackground,
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .padding(16.dp),
                    title = {
                        Text(text = "Поиск")
                    },
                    backgroundColor = ExtendedTheme.colors.screenBackground,
                    contentColor = ExtendedTheme.colors.emailInputLineText,
                    elevation = 0.dp,
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier
                                .padding(16.dp),
                            onClick = { viewModel.setEvent(SearchContract.SearchEvent.getVacanciesByKeywords("asd")) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) {
            SearchFilterModalBottomSheet(
                sheetState = bottomSheetState,
                onConfirmClick = { Log.e("asd", "asd") }
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
                        onNextClick = {}
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
                                    bottomSheetState.show()
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
                        .padding(top = 15.dp)
                ) {
                    Text(text = "Найдено ")
                    Text(text = "35")
                    Text(text = " вакансий")
                }
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(recommendedVacancies) { it ->
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
}