package br.com.francivaldo.notations.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.francivaldo.notations.data.room.dao.NotaDao
import br.com.francivaldo.notations.data.room.entity.NotaEntity

@Database(entities = [(NotaEntity::class)], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun getNotaDao(): NotaDao
    companion object {

        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppRoomDatabase::class.java,
                        "product_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}