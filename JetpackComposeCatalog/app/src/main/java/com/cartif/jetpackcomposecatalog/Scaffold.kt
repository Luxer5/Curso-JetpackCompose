package com.cartif.jetpackcomposecatalog

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }
        },
        scaffoldState = scaffoldState
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White, elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("atras") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        }, actions = {
            IconButton(onClick = { onClickIcon("buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "buscar")
            }
            IconButton(onClick = { onClickIcon("eliminar") }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "eliminar")
            }
        }
    )
}