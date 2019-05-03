package com.mazroid.mvvm.database;

import com.mazroid.mvvm.model.EmpResponse;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by MazRoid on 5/2/2019.
 */
@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addEmp (EmpTable emp);

    @Query("select * from Employee")
    public List<EmpTable> getEmps();

    @Delete
    public void deleteEmp(EmpTable emp);

    @Query("DELETE FROM Employee")
    public void deleteAll();

}
