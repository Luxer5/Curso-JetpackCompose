package com.cartif.jetpackcomposecatalog.model

sealed class Rutas(val route: String) {
    object Pantalla1: Rutas("pantalla1")
    object Pantalla2: Rutas("pantalla2")
    object Pantalla3: Rutas("pantalla3")
}