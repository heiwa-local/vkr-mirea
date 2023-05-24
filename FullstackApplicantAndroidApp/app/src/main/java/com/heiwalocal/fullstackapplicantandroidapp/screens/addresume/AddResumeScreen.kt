package com.heiwalocal.fullstackapplicantandroidapp.screens.addresume

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.screens.addresume.components.AddResumeTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.InputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.MediumInputField
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors.SearchableSelector
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors.Selector
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags.ClickableTags
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags.DeletableTags
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import com.heiwalocal.fullstackapplicantandroidapp.utils.EMPLOYMENT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddResumeScreen(
    navController: NavHostController,
    viewModel: AddResumeViewModel
) {
    val grades = viewModel.grade.observeAsState().value

    var jobTitle by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf(listOf<String>()) }
    var education by remember { mutableStateOf("") }
    var workExperience by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.getGrades()
        Log.e("ffff", grades.toString())
    }

    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        topBar = {
            AddResumeTopBar(
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())

        ) {
            InputLine(
                value = jobTitle,
                onValueChange = {jobTitle = it},
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                placeholder = {
                    Text(text = "Должность")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.GroupWork,
                        contentDescription = null
                    )
                }
            )
            Selector(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = grade,
                items = grades?.map { it.name } ?: listOf("1", "2"),
                onValueChange = { grade = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null,
                        tint = ExtendedTheme.colors.hint
                    )
                }
            )
            InputLine(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = salary,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                onValueChange = {salary = it},
                placeholder = {
                    Text(text = "Зарплата")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Money,
                        contentDescription = null
                    )
                }
            )
            InputLine(
                modifier = Modifier.padding(top = 16.dp),
                value = address,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                onValueChange = {address = it},
                placeholder = {
                    Text(text = "Адрес")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Place,
                        contentDescription = null
                    )
                }
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(skills) { photo ->
                    DeletableTags(
                        text = photo,
                        onClick = {
                            val newList = skills.toMutableList()
                            newList.remove(photo)
                            skills = newList
                        }
                    )
                }
            }
            InputLine(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = skill,
                onValueChange = {skill = it},
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, imeAction = ImeAction.Send),
                onSendClick = {
                    if (skill != "") {
                        val newList = skills.toMutableList()
                        newList.add(skill)
                        skills = newList
                        skill = ""
                        Log.e("aaab", skills.toString())
                    }
                },
                placeholder = {
                    Text(text = "Навыки")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.HealthAndSafety,
                        contentDescription = null
                    )
                }
            )
            MediumInputField(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(200.dp),
                value = education,
                onValueChange = {education = it},
                placeholder = {
                    Text(text = "Образование")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.CastForEducation,
                        contentDescription = null
                    )
                }
            )
            MediumInputField(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(200.dp),
                value = workExperience,
                onValueChange = {workExperience = it},
                placeholder = {
                    Text(text = "Опыт работы")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Work,
                        contentDescription = null
                    )
                }
            )
            LargeButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = {
                    coroutineScope.launch {
                        var gradeId =""

                        grades?.map { it ->
                            if (it.name == grade) {
                                gradeId = it.id
                            }
                        }

                        val result = viewModel.createResume(
                            jobTitle= jobTitle,
                            salary= salary,
                            skills= skills.joinToString(separator = ","),
                            education= education,
                            workExperience= workExperience,
                            gradeId= gradeId,
                            address= address,
                        )
                        if (result) {
                            Toast.makeText(localContext, "Успешно", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        } else {

                            Toast.makeText(localContext, "Ошибка", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            ) {
                Text(text = "Сохранить")
            }
        }
    }
}