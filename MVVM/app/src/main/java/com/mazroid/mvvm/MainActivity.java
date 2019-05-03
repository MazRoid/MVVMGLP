package com.mazroid.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mazroid.mvvm.ViewModel.EmpViewModel;
import com.mazroid.mvvm.adapter.EmpAdapter;
import com.mazroid.mvvm.database.EmpTable;
import com.mazroid.mvvm.database.MyDatabase;
import com.mazroid.mvvm.model.EmpResponse;
import com.mazroid.mvvm.utils.Utility;

import java.util.List;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    RecyclerView Emprecycler;
    public static MyDatabase myDatabase;
    List<EmpTable> empTables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intialize database
        myDatabase = Room.databaseBuilder(MainActivity.this,MyDatabase.class,"empdb").allowMainThreadQueries().build();

        Emprecycler = findViewById(R.id.Emprecycler);
        Emprecycler.setHasFixedSize(true);
        Emprecycler.setLayoutManager(new LinearLayoutManager(this));

         empTables = myDatabase.myDao().getEmps();

        String Info = "";
        for (EmpTable emp : empTables)
        {
            int id  = emp.getId();
            String name = emp.getName();
            String phone = emp.getPhone();

            Info = "id =="+id +"== name== "+name +"  ===mob == "+phone;
            Log.e("Mazhar==Info" , Info);
        }
        Log.e("Mazhar==Info" , Info);

        if(Utility.isNetworkAvailable(MainActivity.this))
        {

        }
        else {
//            Emprecycler.setVisibility(View.GONE);
            myDatabase.myDao().deleteAll();
            Log.e("Mazhar==delete all" , Info);
        }

        EmpViewModel model = ViewModelProviders.of(this).get(EmpViewModel.class);
        model.getEmp().observe(this, new Observer<List<EmpResponse>>() {
            @Override
            public void onChanged(@Nullable List<EmpResponse> empList) {
                EmpAdapter adapter = new EmpAdapter(MainActivity.this, empList);
                Emprecycler.setAdapter(adapter);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        EmpViewModel model = ViewModelProviders.of(this).get(EmpViewModel.class);
        model.getEmp().observe(this, new Observer<List<EmpResponse>>() {
            @Override
            public void onChanged(@Nullable List<EmpResponse> empList) {
                EmpAdapter adapter = new EmpAdapter(MainActivity.this, empList);
                Emprecycler.setAdapter(adapter);
            }
        });
    }


}
