package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancydetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.tabs.Tabs
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun VacancyDetailScreen(

) {
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(16.dp),
                title = {
                },
                backgroundColor = ExtendedTheme.colors.screenBackground,
                contentColor = ExtendedTheme.colors.emailInputLineText,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .padding(16.dp),
                        onClick = { /*TODO*/ }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = Icons.Default.Group,
                    contentDescription = null)
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = "Google",
                    style = ExtendedTheme.typography.h2
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp),
                ) {
                    Text(
                        text = "Spootify",
                        style = ExtendedTheme.typography.h3
                    )
                    Text(
                        text = " – ",
                        style = ExtendedTheme.typography.h3
                    )
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = null
                    )
                    Text(
                        text = "Торонто, Канада",
                        color = ExtendedTheme.colors.hint
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Rounded.Timer,
                            contentDescription = null
                        )
                        Text(
                            text = " Полная занятость"
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        text = "250000 руб/мес",
                        style = ExtendedTheme.typography.h3
                    )
                }
                Tabs(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    items = arrayOf("Описание", "О компании", "Описание", "О компании")
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "web-дизайн (баннеры и ресайзы для рекламных кампаний, сайта и рассылок);" +
                            "разработка и допечатная подготовка полиграфических макетов (бордов, плакатов, листовок, буклетов, наклеек, макетов в газеты/журналы и т. д.);" +
                            "подготовка креативов для социальных сетей (плашки, картинки для постов, сторис);" +
                            "подготовка изображений для презентаций;" +
                            "разработка несложной анимации.",
                )
                LargeButton(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Откликнуться")
                }
            }
        }
    }
}