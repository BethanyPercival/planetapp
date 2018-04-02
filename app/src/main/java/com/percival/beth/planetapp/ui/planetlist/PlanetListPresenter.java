package com.percival.beth.planetapp.ui.planetlist;

import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

public class PlanetListPresenter implements IPlanetListPresenter {

    private IPlanetListView view;
    private PlanetListData data;

    public PlanetListPresenter(IPlanetListView view, PlanetListData data) {
        this.view = view;
        this.data = data;
    }

    @Override
    public void onViewReady() {
        data.getPlanets(this);
    }

    @Override
    public void onDataReady(GetPlanetsResponse getPlanetsResponse) {
        if (getPlanetsResponse.getPlanets() != null) {
            view.populateList(getPlanetsResponse);
        } else {
            view.displayError();
        }
    }

    @Override
    public void listItemSelected(Planet planet) {
        if (planet != null) {
            view.openPlanetDetailsActivity(planet);
        } else {
            view.displayError();
        }
    }
}
