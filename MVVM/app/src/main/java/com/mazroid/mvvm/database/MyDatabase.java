package com.mazroid.mvvm.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by MazRoid on 5/2/2019.
 */

@Database(entities = {EmpTable.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
