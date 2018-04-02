package com.percival.beth.planetapp.network.response;

import com.percival.beth.planetapp.model.Planet;

import java.util.List;

public class GetPlanetsResponse {
    private List<Planet> planets;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
