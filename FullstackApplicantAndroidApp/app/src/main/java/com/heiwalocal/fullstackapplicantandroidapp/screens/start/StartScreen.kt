package com.heiwalocal.fullstackapplicantandroidapp.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.R
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton

@Composable
fun StartScreen (

) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.dude_on_chair
                ),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Найди свою идеальную работу в IT!",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Вместе с FullStack это проще простого",
                textAlign = TextAlign.Center
            )
            LargeButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Начать")
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}