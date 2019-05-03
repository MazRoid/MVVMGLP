package com.mazroid.mvvm.retrofit;

import com.mazroid.mvvm.model.EmpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MazRoid on 5/2/2019.
 */
public interface ApiInterface {
    @GET("users")
    Call<List<EmpResponse>> getEmpdetails();

}
