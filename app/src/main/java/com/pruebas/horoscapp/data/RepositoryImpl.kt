package com.pruebas.horoscapp.data

import android.util.Log
import com.pruebas.horoscapp.data.network.HoroscopeApiService
import com.pruebas.horoscapp.data.network.response.PredictionResponse
import com.pruebas.horoscapp.domain.Repository
import com.pruebas.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("monto", "Ha ocurrido un error ${it.message}") }
        return null
    }
}