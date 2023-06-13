package com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail.components.ResumeDetailTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@Composable
fun ResumeDetailScreen(
    navController: NavHostController,
    viewModel: ResumeDetailViewModel,
) {
    val resume = viewModel.resume.observeAsState().value

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.getResume(
            resumeId = navController.previousBackStackEntry?.savedStateHandle?.get<String>("clicked_resume").toString(),
        )
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ResumeDetailTopBar(
                navController = navController,
                resumeId = resume?.id.toString()
            )
        },
        backgroundColor = ExtendedTheme.colors.screenBackground
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier,
                text = "Должность",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.jobTitle.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Уровень проффесиональных навыков",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.grade.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Зарплата",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "${resume?.salary?.toInt().toString()} руб/мес"
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Адрес",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.address.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Навыки",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.skills.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Образование",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.education.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Опыт работы",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.workExperience.toString()
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Дата создания",
                style = ExtendedTheme.typography.h2
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = resume?.datetime.toString()
                )
            }
            LargeButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                backgroundColor = ExtendedTheme.colors.close,
                onClick = {
                    coroutineScope.launch {
                        viewModel.deleteResume(
                            resumeId = navController.previousBackStackEntry?.savedStateHandle?.get<String>(
                                "clicked_resume"
                            ).toString(),
                        )
                        navController.popBackStack()
                    }
            }) {
                Text(text = "Удалить резюме")
            }
        }
    }
}