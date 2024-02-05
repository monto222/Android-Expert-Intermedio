package com.pruebas.horoscapp.domain

import com.pruebas.horoscapp.data.network.response.PredictionResponse
import com.pruebas.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sing:String): PredictionModel?
}