package com.example.binlistapp.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.contact.presentation.ToConnectProvider
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.util.Resource
import kotlinx.coroutines.launch

class SearchViewModel(val interactor: SearchingInteractor) : ViewModel(), ToConnectProvider {

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

    override fun goToCall(phone: String) {
        interactor.moveToCall(phone)
    }

    override fun goToMap(latitude: Long, longitude: Long) {
        interactor.goToMap(latitude, longitude)
    }

    override fun goToUrl(bankUrl: String) {
        interactor.moveToUrl(bankUrl)
    }

    companion object {
        const val MIN_LENGTH = 6
        const val MAX_LENGTH = 8
    }
}
