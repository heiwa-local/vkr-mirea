package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.Resumes
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.SmallResumeCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VacancyInfoJobPostingModalBottomSheet(
    resumes: List<Resume>?,
    sheetState: ModalBottomSheetState,
    onConfirmClick: (String) -> Unit,
    content: @Composable () -> Unit,
) {

    var selected by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
//        scrimColor = Color.Transparent,
        sheetBackgroundColor = ExtendedTheme.colors.screenBackground,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .padding(top = 4.dp),
                        thickness = 3.dp
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = "Выберите резюме",
                    style = ExtendedTheme.typography.h2
                )
                if (resumes != null && resumes.isNotEmpty()) {
                    LazyRow(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(resumes) {
                            SmallResumeCard(
                                jobTitle = it.jobTitle.toString(),
                                background = if (selected == it.id.toString()) {ExtendedTheme.colors.largeButtonBackground} else {ExtendedTheme.colors.largeButtonContent},
                                content = if (selected == it.id.toString()) {ExtendedTheme.colors.largeButtonContent} else {ExtendedTheme.colors.text},
                                salary = it.salary.toString(),
                                datetime = it.datetime.toString(),
                                onClick = {
                                    selected = it.id.toString()
                                }
                            )
                        }
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .height(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Создайте резюме, чтобы оставить отклик",
                            style = ExtendedTheme.typography.h3,
                            color = ExtendedTheme.colors.hint
                        )
                    }
                }
                LargeButton(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    onClick = {
                        onConfirmClick(
                            selected
                        )
                    }
                ) {
                    Text(
                        text = "Отправить"
                    )
                }
            }
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        content()
    }
}