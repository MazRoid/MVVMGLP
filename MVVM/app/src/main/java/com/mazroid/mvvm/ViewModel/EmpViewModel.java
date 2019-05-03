package com.mazroid.mvvm.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

import com.mazroid.mvvm.retrofit.ApiClient;
import com.mazroid.mvvm.retrofit.ApiInterface;

import com.mazroid.mvvm.model.EmpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MazRoid on 5/2/2019.
 */

public class EmpViewModel  extends ViewModel {
    private MutableLiveData<List<EmpResponse>> empList;

    public LiveData<List<EmpResponse>> getEmp() {
        //if the list is null
        if (empList == null) {
            empList = new MutableLiveData<List<EmpResponse>>();
            loadEmp();
        }

        //finally we will return the list
        return empList;
    }

    private void loadEmp() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<EmpResponse>> call = apiService.getEmpdetails();
        call.enqueue(new Callback<List<EmpResponse>>() {
            @Override
            public void onResponse(Call<List<EmpResponse>> call, Response<List<EmpResponse>> response) {
                empList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<EmpResponse>>call, Throwable t) {
                // Log error here since request failed
                Log.e("Mazroid ::Fail:: ", t.toString());
            }
        });}

}

