package com.kurowskiandrzej.chessclock.di

import android.app.Application
import androidx.room.Room
import com.kurowskiandrzej.chessclock.db.ChessClockDao
import com.kurowskiandrzej.chessclock.db.ChessClockDatabase
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepositoryImpl
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(context: Application) = ChessClockDatabase.getInstance(context)

    @Singleton
    @Provides
    fun injectDao(database: ChessClockDatabase) = database.dao

    @Singleton
    @Provides
    fun injectRepository(dao: ChessClockDao) = ChessClockRepositoryImpl(dao) as ChessClockRepository
}