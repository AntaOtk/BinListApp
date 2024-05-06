package com.example.binlistapp.search.presentation

import android.content.Context
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.R
import com.example.binlistapp.contact.domain.ConnectInteractor
import com.example.binlistapp.contact.presentation.ToConnectProvider
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.util.Resource
import kotlinx.coroutines.launch

class SearchViewModel(
    private val interactor: SearchingInteractor,
    private val connectInteractor: ConnectInteractor,
    private val context: Context
) : ViewModel(), ToConnectProvider {

    private val _infoState = MutableLiveData<SearchState>()
    val cardState: LiveData<SearchState> = _infoState
    private fun setInfoState(data: SearchState) {
        _infoState.value = data
    }

    fun searchInfo(input: String) {
        if (input.length > MIN_LENGTH) {
            viewModelScope.launch {
                val bin = if (input.length <= MAX_LENGTH) input else input.substring(0, 7)
                interactor.searchInfo(bin).collect { result ->
                    when (result) {
                        is Resource.Success -> setInfoState(SearchState.Content(result.data!!))
                        is Resource.Error -> setInfoState(SearchState.Error(result.message!!))
                    }
                }
            }
        } else {
            setInfoState(SearchState.Error(getString(context, R.string.message_input_error)))
        }
    }

    override fun goToCall(phone: String) {
        connectInteractor.goToCall(phone)
    }

    override fun goToMap(latitude: Long, longitude: Long) {
        connectInteractor.goToMap(latitude, longitude)
    }

    override fun goToUrl(bankUrl: String) {
        connectInteractor.goToUrl(bankUrl)
    }

    companion object {
        const val MIN_LENGTH = 6
        const val MAX_LENGTH = 8
    }
}
