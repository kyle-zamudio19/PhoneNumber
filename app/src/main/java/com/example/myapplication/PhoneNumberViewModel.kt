package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PhoneNumberViewModel(private val phoneNumberDao: PhoneNumberDao): ViewModel() {
    val phoneNumbers: LiveData<List<PhoneNumber>> = phoneNumberDao.getAllPhoneNumbers()

    fun insertPhoneNumber(phoneNumber: PhoneNumber){
        viewModelScope.launch {
            phoneNumberDao.insertPhoneNumber(phoneNumber)
        }
    }
}