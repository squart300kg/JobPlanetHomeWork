package com.jobplanet.kr.android.ui.sub

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jobplanet.kr.android.base.BaseViewModel
import com.jobplanet.kr.android.model.response.CompanyResponse
import com.jobplanet.kr.android.model.response.RecrutesResponse
import com.jobplanet.kr.android.repository.CompanyRepository
import com.jobplanet.kr.android.repository.RecruteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val repository: CompanyRepository
) : BaseViewModel() {

    private val _companyResponse = MutableLiveData<CompanyResponse>()
    val companyResponse: LiveData<CompanyResponse>
        get() = _companyResponse

//    lateinit var clickListener: View.OnClickListener

    fun getCompanies() {
        job?.cancel()
        job = viewModelScope.launch {
            repository.getCompanies()
                .catch {
                    // TODO: 어떻게 처리할지 고민
                }
                .collect { response ->
                    _companyResponse.value = response
                    Log.i("companyResponse", "$response")
                }
        }

    }
}