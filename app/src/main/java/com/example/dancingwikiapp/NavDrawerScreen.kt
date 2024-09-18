package com.example.dancingwikiapp

import MovementCard
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottombarexample.NavigationItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        NavigationItem(
            title = "Posições",
            selectedIcon = ImageVector.vectorResource(id = R.drawable.position_nav_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.position_nav_icon)
        ),
        NavigationItem(
            title = "Movimentos",
            selectedIcon = ImageVector.vectorResource(id = R.drawable.movement_nav_icon),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.movement_nav_icon),
            badgeCount = 46
        ),
        NavigationItem(
            title = "Sobre Nós",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info
        )
    )
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        when (index){
                            0 -> navController.navigate("positionSearch")
                            1 -> navController.navigate("movementSearch")
                            2 -> navController.navigate("aboutUs")
                        }
                                  },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else {
                                    item.unselectedIcon
                                },
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        }
                    )

                }
            }

        },
        drawerState = drawerState
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Ballet Para Todos")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }

                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )

                        }
                    }
                )
            }
        ) {
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    // Your main screen content
                    // ...
                }
                composable("movementSearch") {
                    SearchMovementsScreen(navController)
                }
                composable("positionSearch") {
                    SearchPositionsScreen(navController)
                }
                composable("aboutUs") {
                    // Your "About Us" screen content
                    // ...
                }
                composable("movement/{movementId}") { backStackEntry ->
                    val movementId = backStackEntry.arguments?.getString("movementId")
                    val movement = Movements.find { it.id == movementId?.toInt() }
                    movement?.let {
                        MovementCard(movement)
                    }
                }
            }
        }
    }
}