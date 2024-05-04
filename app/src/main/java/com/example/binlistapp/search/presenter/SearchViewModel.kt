package com.example.binlistapp.search.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.util.Resource
import kotlinx.coroutines.launch

class SearchViewModel(val interactor: SearchingInteractor) : ViewModel() {

    private val _infoState = MutableLiveData<SearchState>()
    val cardState: LiveData<SearchState> = _infoState
    private fun setInfoState(data: SearchState) {
        _infoState.value = data
    }

    fun searchInfo(bin: String) {
        if (bin.length in MIN_LENGTH..MAX_LENGTH) {
            viewModelScope.launch {
                interactor.searchInfo(bin).collect { result ->
                    when (result) {
                        is Resource.Success -> setInfoState(SearchState.Content(result.data!!))
                        is Resource.Error -> setInfoState(SearchState.Error(result.message!!))
                    }

                }
            }
        } else {
            setInfoState(SearchState.Error("Enter the first 6 to 8 digits of a card number"))
        }
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

    companion object {
        const val MIN_LENGTH = 6
        const val MAX_LENGTH = 8
    }
}
