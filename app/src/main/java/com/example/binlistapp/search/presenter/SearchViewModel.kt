package com.example.binlistapp.search.presenter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.domain.model.InfoData
import kotlinx.coroutines.launch

class SearchViewModel(val interactor: SearchingInteractor) : ViewModel() {

    private val _infoData = MutableLiveData<InfoData?>()
    val infoData: LiveData<InfoData?> = _infoData
    fun setInfoData(data: InfoData?) {
        _infoData.value = data
    }

    fun searchInfo(bin: String) {
        if (bin.length in MIN_LENGTH..MAX_LENGTH) {
            viewModelScope.launch {
                interactor.searchInfo(bin).collect { info ->
                    setInfoData(info)
                }
            } }else { Log.d("input", "info $bin ${bin.length} in $MIN_LENGTH..$MAX_LENGTH")}
    }

    fun moveToCall(phone: String) {
        interactor.moveToCall(phone)
    }

    fun moveToMap(country: String) {
        interactor.moveToMap(country)
    }
    fun moveToUrl(bankUrl: String) {
        interactor.moveToUrl(bankUrl)
    }

    companion object{
        const val MIN_LENGTH= 6
        const val MAX_LENGTH= 8
    }
}
