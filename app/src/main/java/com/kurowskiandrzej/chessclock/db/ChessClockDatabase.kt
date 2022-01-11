package com.kurowskiandrzej.chessclock.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kurowskiandrzej.chessclock.db.entity.TimeControl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [TimeControl::class], version = 1)
abstract class ChessClockDatabase: RoomDatabase() {
    abstract val dao: ChessClockDao

    companion object {
        private lateinit var database: ChessClockDatabase

        @Volatile
        private var INSTANCE: ChessClockDatabase? = null
        fun getInstance(context: Context): ChessClockDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = createInstance(context)
                }
                return instance
            }
        }

        private fun createInstance(context: Context): ChessClockDatabase {
            database = Room.databaseBuilder(
                context.applicationContext,
                ChessClockDatabase::class.java,
                "chess-clock-database"
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        database.dao.insertTimeControl("1 | 1", 1 * 60, 1 * 60)
                    }
                }
            })
                .build()
            return database
        }

        fun getTestInstance(context: Context): ChessClockDatabase {
            return Room.inMemoryDatabaseBuilder(context, ChessClockDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        }
    }
}