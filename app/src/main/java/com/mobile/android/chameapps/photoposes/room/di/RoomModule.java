package com.mobile.android.chameapps.photoposes.room.di;

import android.app.Application;
import androidx.room.Room;
import com.mobile.android.chameapps.photoposes.room.AppDatabase;
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

import static com.mobile.android.chameapps.photoposes.constants.Constants.DB_NAME;

/**
 * Created by n.zhabitskaya on 9/30/18.
 */

@Module
public class RoomModule {

    private AppDatabase database;

    public RoomModule(Application mApplication) {
        database = Room.databaseBuilder(mApplication, AppDatabase.class, DB_NAME).build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return database;
    }

    @Singleton
    @Provides
    ItemsDao providesItemsDao(AppDatabase database) {
        return database.itemsDao();
    }
}
