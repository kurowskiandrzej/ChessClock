package com.kurowskiandrzej.chessclock.di

import android.content.Context
import androidx.navigation.Navigator
import androidx.room.Room
import com.kurowskiandrzej.chessclock.db.ChessClockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("testDatabase")
    fun injectInMemoryRoomDatabase(@ApplicationContext context: Context) = ChessClockDatabase.getTestInstance(context)
}