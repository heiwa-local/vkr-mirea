package com.heiwalocal.fullstackapplicantandroidapp.ui.components.modalbottomsheets

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.entities.Direction
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.InputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors.SearchableSelector
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors.Selector
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags.ClickableTags
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import com.heiwalocal.fullstackapplicantandroidapp.utils.EMPLOYMENT
import com.heiwalocal.fullstackapplicantandroidapp.utils.getKey

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun SearchFilterModalBottomSheet(
    sheetState: ModalBottomSheetState,
    directions: List<Direction>?,
    onConfirmClick: (Map<String, String?>) -> Unit,
    content: @Composable () -> Unit,
) {

    var type by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    val tags by remember { mutableStateOf(mutableListOf<String>()) }

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
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "Категория",
                    style = ExtendedTheme.typography.h3,
                )
                Selector(
                    value = type,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    items = directions?.map { it.name } ?: emptyList(),
                    onValueChange = { type = it },
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
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
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(EMPLOYMENT.values.map { it }) { photo ->
                        ClickableTags(
                            selectedColor = ExtendedTheme.colors.largeButtonBackground,
                            unselectedColor = ExtendedTheme.colors.largeButtonContent,
                            text = photo,
                            onClick = {
                                if (it) {
                                    tags.add(getKey(EMPLOYMENT, photo)!!)
                                } else {
                                    tags.remove(getKey(EMPLOYMENT, photo)!!)
                                }
                                Log.e("bbbb", tags.toString())

                            }
                        )
                    }
                }
                LargeButton(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    onClick = {
                        onConfirmClick(
                            mapOf(
                                "type" to type,
                                "salary" to salary,
                                "tags" to tags.joinToString(separator = ",")
                            )
                        )
                    }
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