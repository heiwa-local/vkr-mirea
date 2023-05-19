package com.heiwalocal.fullstackapplicantandroidapp.ui.components.modalbottomsheets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.InputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors.SearchableSelector
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags.ClickableTags
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun SearchFilterModalBottomSheet(
    sheetState: ModalBottomSheetState,
    onConfirmClick: () -> Unit,
    content: @Composable () -> Unit,
) {

    var salary by remember { mutableStateOf("") }

    ModalBottomSheetLayout(
        sheetBackgroundColor = ExtendedTheme.colors.screenBackground,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Фильтр",
                    style = ExtendedTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "Категория",
                    style = ExtendedTheme.typography.h3,
                )
                SearchableSelector(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    items = arrayOf("UX/UI Design", "Backend", "Frontend")
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Регион",
                            style = ExtendedTheme.typography.h3,
                        )
                        SearchableSelector(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            items = arrayOf("Москва", "Санкт-Петербург")
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Зарплата",
                                style = ExtendedTheme.typography.h3,
                            )
                            Text(
                                text = " (руб/мес)",
                                style = ExtendedTheme.typography.body1,
                                color = ExtendedTheme.colors.hint
                            )
                        }
                        InputLine(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            value = salary,
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            onValueChange = {salary = it}
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "Занятость",
                    style = ExtendedTheme.typography.h3,
                )
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    cells = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(arrayOf("1","2", "3")) { photo ->
                        ClickableTags(
                            selectedColor = ExtendedTheme.colors.largeButtonBackground,
                            unselectedColor = ExtendedTheme.colors.largeButtonContent,
                            text = "Полная занятость"
                        )
                    }
                }
                LargeButton(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    onClick = onConfirmClick
                ) {
                    Text(text = "Применить")
                }

            }
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        content()
    }
}