package com.percival.beth.planetapp.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequest {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://bethanypercival.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Single<GetPlanetsResponse> getPlanets() {
        NetworkTask networkTask = retrofit.create(NetworkTask.class);
        return networkTask.getPlanets();
    }
}
