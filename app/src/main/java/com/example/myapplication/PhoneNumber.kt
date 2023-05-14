package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phone_numbers", primaryKeys = ["id"])
data class PhoneNumber(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val number: Int,
    val imageUri: String? = null
)