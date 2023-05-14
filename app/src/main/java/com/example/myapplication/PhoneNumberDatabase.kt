package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PhoneNumber::class], version = 1, exportSchema = false)
abstract class PhoneNumberDatabase: RoomDatabase() {
    abstract fun phoneNumberDao(): PhoneNumberDao

    companion object {

        @Volatile
        private var INSTANCE: PhoneNumberDatabase? = null

        fun getDatabase(context: Context): PhoneNumberDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    PhoneNumberDatabase::class.java,
                    "phone_number_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}