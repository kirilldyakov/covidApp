package ru.strongit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.strongit.covid.model.db.CountryDB
import ru.strongit.local.converter.Converters
import ru.strongit.local.dao.CountryDao

@Database(entities = [CountryDB::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CovidAppDatabase : RoomDatabase() {

    // DAO
    abstract fun countryDao(): CountryDao

    companion object {

        fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, CovidAppDatabase::class.java, "CovidApp.db")
                        .fallbackToDestructiveMigration()
                        .build()
    }
}