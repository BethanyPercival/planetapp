package com.percival.beth.planetapp.ui.planetlist;

import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

public interface IPlanetListView {
    void populateList(GetPlanetsResponse getPlanetsResponse);

    void displayError();

    void openPlanetDetailsActivity(Planet planet);
}
