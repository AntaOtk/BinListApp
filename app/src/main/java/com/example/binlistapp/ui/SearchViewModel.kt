package com.example.binlistapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.damain.SearchingInteractor
import com.example.binlistapp.damain.model.InfoData
import kotlinx.coroutines.launch

class SearchViewModel(val interactor: SearchingInteractor) : ViewModel() {

    private val infoLiveData =  MutableLiveData<InfoData>()
    fun observeInfoLiveData(): LiveData<InfoData> = infoLiveData

    fun searchInfo(bin: String) {
        viewModelScope.launch {
            interactor.searchInfo(bin).collect { info ->
                infoLiveData.postValue(info)
            }
        }
    }

}
