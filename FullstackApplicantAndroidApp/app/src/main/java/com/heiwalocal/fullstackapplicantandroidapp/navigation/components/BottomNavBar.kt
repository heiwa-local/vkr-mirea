package com.heiwalocal.fullstackapplicantandroidapp.navigation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = modifier,
        elevation = 0.dp,
        backgroundColor = ExtendedTheme.colors.screenBackground
    ){
        items.forEach{ item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = ExtendedTheme.colors.largeButtonBackground,
                unselectedContentColor = ExtendedTheme.colors.hint,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Badge{
                                        Text(text = item.badgeCount.toString())
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )
                    }
                }
            )
        }

    }
}