package com.percival.beth.planetapp.ui.planetlist;

import com.percival.beth.planetapp.network.ApiRequest;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PlanetListData {

    private ApiRequest apiRequest;

    PlanetListData() {
        this.apiRequest = new ApiRequest();
    }

    public void getPlanets(final PlanetListPresenter presenter) {
        apiRequest.getPlanets()
                .subscribeOn(Schedulers.io())
                .onErrorReturnItem((new GetPlanetsResponse()))
                .subscribe(new Consumer<GetPlanetsResponse>() {
                    @Override
                    public void accept(GetPlanetsResponse getPlanetsResponse) throws Exception {
                        presenter.onDataReady(getPlanetsResponse);
                    }
                });
    }
}
