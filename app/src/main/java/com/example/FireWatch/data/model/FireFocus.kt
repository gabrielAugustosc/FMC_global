package com.globalSolution.FireWatch.data.model

import com.google.android.gms.maps.model.LatLng

enum class Severidade { BAIXO, MEDIO, CRITICO }

data class FocoIncendio(
    val localizacao: LatLng,
    val severidade: Severidade
)