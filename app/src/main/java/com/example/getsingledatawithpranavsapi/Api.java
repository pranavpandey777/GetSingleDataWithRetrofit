package com.example.getsingledatawithpranavsapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://form420.000webhostapp.com/";

@GET("getone/{email}")
    Call<Data> getData(@Path("email") String email);



}
