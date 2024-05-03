package com.example.binlistapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.damain.Search.SearchingInteractor
import com.example.binlistapp.damain.model.InfoData
import kotlinx.coroutines.launch

class SearchViewModel(val interactor: SearchingInteractor) : ViewModel() {

    private val _infoData = MutableLiveData<InfoData?>()
    val infoData: LiveData<InfoData?> = _infoData
    fun setInfoData(data: InfoData?) {
        _infoData.value = data
    }

    fun searchInfo(bin: String) {
        viewModelScope.launch {
            interactor.searchInfo(bin).collect { info ->
                setInfoData(info)
            }
        }
    }

}
