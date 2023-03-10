package com.jobplanet.kr.android.repository


import com.jobplanet.kr.android.model.response.CompanyResponse
import com.jobplanet.kr.android.model.response.RecrutesResponse
import kotlinx.coroutines.flow.Flow

interface CompanyRepository {

    fun getCompanies(): Flow<CompanyResponse>
}