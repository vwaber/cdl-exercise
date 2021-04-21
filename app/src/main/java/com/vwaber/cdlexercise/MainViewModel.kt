package com.vwaber.cdlexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    data class ViewState(
        val destination: Destination = Destination.REQUEST_EQUIPMENT
    )

    enum class Destination {
        REQUEST_EQUIPMENT, ACTIVE_RENTALS, OPEN_REQUESTS, MY_YARD
    }

    private val _viewState: MutableLiveData<ViewState> = MutableLiveData()
    val viewState: LiveData<ViewState> = _viewState

    init {
        _viewState.value = ViewState()
    }

    private fun currentViewState(): ViewState = _viewState.value!!

    fun setDestination(newDestination: Destination) {
        _viewState.value = currentViewState().copy(destination = newDestination)
    }

}