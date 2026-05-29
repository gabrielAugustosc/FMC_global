package com.globalSolution.FireWatch.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FireWatch.ui.components.AgroHeader
import com.example.FireWatch.ui.components.AgroInputField
import com.example.FireWatch.ui.components.AgroOutlineButton
import com.globalSolution.FireWatch.ui.theme.AppColors


@Composable
fun SignUpScreen(onNavigateBack: () -> Unit, onSignUpClick: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(AppColors.Background).padding(horizontal = 24.dp).verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AgroHeader(title = "Cadastre sua Propriedade", onBackClick = onNavigateBack)
        Spacer(modifier = Modifier.height(24.dp))
        AgroInputField(label = "Nome Completo", value = nome, placeholder = "José da Silva", onValueChange = { nome = it })
        Spacer(modifier = Modifier.height(16.dp))
        AgroInputField(label = "E-mail", value = email, placeholder = "seu@email.com", onValueChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))
        AgroInputField(label = "Senha", value = senha, placeholder = "********", onValueChange = { senha = it }, isPassword = true)
        Spacer(modifier = Modifier.height(32.dp))
        Text("Localização", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = AppColors.TextDark)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(modifier = Modifier.weight(1f)) { AgroInputField("Latitude", latitude, "-15.7939", { latitude = it }) }
            Box(modifier = Modifier.weight(1f)) { AgroInputField("Longitude", longitude, "-47.8828", { longitude = it }) }
        }
        Spacer(modifier = Modifier.height(24.dp))
        AgroOutlineButton(text = "Permitir Localização Atual", onClick = { latitude = "-15.7939"; longitude = "-47.8828" })
        Spacer(modifier = Modifier.height(48.dp))
        AgroPrimaryButton(text = "Iniciar Monitoramento", onClick = onSignUpClick)
        Spacer(modifier = Modifier.height(32.dp))
    }
}