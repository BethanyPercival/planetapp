package com.percival.beth.planetapp.ui.planetlist;

import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

public interface IPlanetListPresenter {
    void onViewReady();

    void onDataReady(GetPlanetsResponse getPlanetsResponse);

    void listItemSelected(Planet planet);
}
