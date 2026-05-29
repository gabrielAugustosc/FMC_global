package com.globalSolution.FireWatch.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FireWatch.ui.components.AgroInputField
import com.example.FireWatch.ui.components.AppLogoAndTitle
import com.globalSolution.FireWatch.ui.theme.AppColors


@Composable
fun LoginScreen(onLoginClick: () -> Unit, onNavigateToSignUp: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(AppColors.Background).padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppLogoAndTitle()

        Spacer(modifier = Modifier.height(48.dp))

        AgroInputField(label = "E-mail", value = email, placeholder = "seu@email.com", onValueChange = { email = it })

        Spacer(modifier = Modifier.height(16.dp))

        AgroInputField(label = "Senha", value = password, placeholder = "********", onValueChange = { password = it }, isPassword = true)

        Spacer(modifier = Modifier.height(32.dp))

        // Chamada do nosso componente de botão agora funcional
        AgroPrimaryButton(text = "Entrar", onClick = onLoginClick)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Não tem uma conta? Cadastre-se",
            color = AppColors.TextMuted, fontSize = 14.sp,
            modifier = Modifier.clickable { onNavigateToSignUp() }
        )
    }
}

// Componente do botão preenchido com o layout
@Composable
fun AgroPrimaryButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}