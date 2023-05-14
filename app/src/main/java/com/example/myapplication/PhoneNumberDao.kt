package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhoneNumberDao {

    @Insert
    suspend fun insertPhoneNumber(phoneNumber: PhoneNumber)

    @Query("SELECT * FROM phone_numbers")
    fun getAllPhoneNumbers(): LiveData<List<PhoneNumber>>

    @Query("SELECT * FROM phone_numbers ORDER BY name ASC")
    suspend fun getAllPhoneNumberSortedByName(): List<PhoneNumber>

    @Query("SELECT * FROM phone_numbers ORDER BY number ASC")
    suspend fun getAllPhoneNumberSortedByNumber(): List<PhoneNumber>
}