package com.vwaber.cdlexercise.ui.requestequipment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RequestequipmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is requestequipment Fragment"
    }
    val text: LiveData<String> = _text
}