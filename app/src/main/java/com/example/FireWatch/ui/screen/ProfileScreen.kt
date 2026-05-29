package com.globalSolution.FireWatch.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FireWatch.ui.components.AgroHeader
import com.example.FireWatch.ui.components.AgroInputField
import com.globalSolution.FireWatch.ui.theme.AppColors


@Composable
fun ProfileScreen(onNavigateBack: () -> Unit, onLogout: () -> Unit) {
    var nome by remember { mutableStateOf("José da Silva") }
    var email by remember { mutableStateOf("jose.silva@email.com") }

    Column(
        modifier = Modifier.fillMaxSize().background(AppColors.Background).padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AgroHeader(title = "Meu Perfil", onBackClick = onNavigateBack)
        Spacer(modifier = Modifier.height(32.dp))

        // Avatar com ícone de câmera
        Box(contentAlignment = Alignment.BottomEnd) {
            Surface(shape = CircleShape, color = AppColors.Primary, modifier = Modifier.size(100.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Text("JS", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                }
            }
            Surface(shape = CircleShape, color = Color.White, shadowElevation = 4.dp, modifier = Modifier.size(32.dp).offset(x = (-4).dp, y = (-4).dp)) {
                Icon(Icons.Default.CameraAlt, contentDescription = "Editar Foto", modifier = Modifier.padding(6.dp), tint = AppColors.TextMuted)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
            Text("Dados Pessoais", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = AppColors.TextDark)
            Spacer(modifier = Modifier.height(16.dp))
            AgroInputField("Nome Completo", nome, "", { nome = it })
            Spacer(modifier = Modifier.height(16.dp))
            AgroInputField("E-mail", email, "", { email = it })

            Spacer(modifier = Modifier.height(24.dp))
            Text("Segurança", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = AppColors.TextDark)
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Alterar senha lógica */ },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEBEFEB)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Alterar Senha", color = AppColors.TextDark, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        AgroPrimaryButton(text = "Salvar Alterações", onClick = onNavigateBack)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Sair da Conta",
            color = AppColors.Terracotta,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable { onLogout() }.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}