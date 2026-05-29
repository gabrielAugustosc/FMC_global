package com.globalSolution.FireWatch.data.service


import com.globalSolution.FireWatch.data.model.FocoIncendio
import com.globalSolution.FireWatch.data.model.Severidade
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FireService {

    // Função que vai na internet buscar os dados
    suspend fun getFocosDeIncendioDoInpe(): List<FocoIncendio> {
        return withContext(Dispatchers.IO) {
            try {
                val calendar = Calendar.getInstance()
                calendar.add(Calendar.DAY_OF_MONTH, -1)
                val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
                val dataArquivo = dateFormat.format(calendar.time)

                val urlString = "https://dataserver-coids.inpe.br/queimadas/queimadas/focos/csv/diario/Brasil/focos_diario_br_$dataArquivo.csv"
                val csvData = URL(urlString).readText()
                val lines = csvData.lines().filter { it.isNotBlank() }

                if (lines.isNotEmpty()) {
                    val header = lines[0].split(",")
                    val latIndex = header.indexOfFirst { it.contains("lat", ignoreCase = true) }
                    val lonIndex = header.indexOfFirst { it.contains("lon", ignoreCase = true) }

                    if (latIndex != -1 && lonIndex != -1) {
                        lines.drop(1).mapNotNull { line ->
                            val columns = line.split(",")
                            if (columns.size > maxOf(latIndex, lonIndex)) {
                                val lat = columns[latIndex].toDoubleOrNull()
                                val lon = columns[lonIndex].toDoubleOrNull()
                                if (lat != null && lon != null) {
                                    val severidadeRandom = Severidade.values().random()
                                    FocoIncendio(LatLng(lat, lon), severidadeRandom)
                                } else null
                            } else null
                        }.take(150)
                    } else emptyList()
                } else emptyList()
            } catch (e: Exception) {
                emptyList() // Retorna vazio se der erro (ex: sem internet)
            }
        }
    }
}