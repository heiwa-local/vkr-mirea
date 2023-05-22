package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.components.*
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VacancyInfoScreen(
    navController: NavHostController,
    viewModel: VacancyInfoViewModel
) {
    val vacancyInfo = viewModel.vacancyInfo.observeAsState().value
    val resumes = viewModel.resumes.observeAsState().value

    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getVacancyInfoByVacancyId(
            vacancyId = navController.previousBackStackEntry?.savedStateHandle?.get<String>("clicked_vacancy").toString(),
        )
        viewModel.getResumesByUserId()
    }
    VacancyInfoJobPostingModalBottomSheet(
        resumes = resumes,
        sheetState = bottomSheetState,
        onConfirmClick = {
            coroutineScope.launch {
                val response = viewModel.postJobPosting(
                    vacancyId = vacancyInfo?.id.toString(),
                    resumeId = it
                )

                if (response) {
                    viewModel.getVacancyInfoByVacancyId(
                        vacancyId = navController.previousBackStackEntry?.savedStateHandle?.get<String>("clicked_vacancy").toString(),
                    )
                    Toast.makeText(localContext, "Успешно", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(localContext, "Ошибка", Toast.LENGTH_SHORT).show()
                }
                bottomSheetState.hide()

            }
        }
    ) {
        Scaffold(
            backgroundColor = ExtendedTheme.colors.screenBackground,
            topBar = {
                VacancyInfoTopBar(
                    navController = navController
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                VacancyInfoImageView(
                    organizationLogoUrl = vacancyInfo?.organizationLogoUrl.toString()
                )
                VacancyInfoBaseInfoView(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    jobTitle = vacancyInfo?.jobTitle.toString(),
                    grade = vacancyInfo?.grade.toString(),
                    organizationName = vacancyInfo?.organizationName.toString(),
                    address = vacancyInfo?.address.toString(),
                    employment = vacancyInfo?.employment.toString(),
                    salary = vacancyInfo?.salary.toString(),
                    direction = vacancyInfo?.direction.toString(),
                )
                VacancyInfoTabs(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    description = vacancyInfo?.description.toString(),
                    organizationDescription = vacancyInfo?.organizationDescription.toString()
                )
                LargeButton(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    backgroundColor = if (vacancyInfo?.jobPostingId != null) {ExtendedTheme.colors.close} else {ExtendedTheme.colors.largeButtonBackground},
                    onClick = {
                        if (vacancyInfo?.jobPostingId != null) {
                            coroutineScope.launch {
                                val result = viewModel.deleteJobPosting(
                                    vacancyInfo.jobPostingId.toString()
                                )
                                if (result) {
                                    Toast.makeText(localContext, "Успешно", Toast.LENGTH_SHORT).show()
                                    viewModel.getVacancyInfoByVacancyId(
                                        vacancyId = navController.previousBackStackEntry?.savedStateHandle?.get<String>("clicked_vacancy").toString(),
                                    )
                                } else {
                                    Toast.makeText(localContext, "Ошибка", Toast.LENGTH_SHORT).show()
                                }
                            }
                        } else {
                            coroutineScope.launch {
                                bottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    }
                ) {
                    Text(text = if (vacancyInfo?.jobPostingId != null) {"Отменить отклик"} else {"Откликнуться"})
                }
            }
        }
    }
}