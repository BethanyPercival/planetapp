package com.percival.beth.planetapp.network;

import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NetworkTask {

    @GET("planets")
    Single<GetPlanetsResponse> getPlanets();
}
