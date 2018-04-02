package com.percival.beth.planetapp.ui.planetlist;

import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlanetListPresenterTest {

    @Mock
    private IPlanetListView mockView;
    @Mock
    private PlanetListData mockData;
    @Mock
    private Planet mockPlanet;
    @Mock
    private GetPlanetsResponse mockGetPlanetsResponse;

    private PlanetListPresenter mockPresenter;

    private static final GetPlanetsResponse NULL_RESPONSE = new GetPlanetsResponse();
    private static final Planet EMPTY_PLANET = new Planet();

    private static final String PLANET_NAME = "Planet Name";

    @Before
    public void setUp() throws Exception {
        mockPresenter = new PlanetListPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetPlanets_whenViewReadyIsCalled() {
        mockPresenter.onViewReady();

        verify(mockData).getPlanets(mockPresenter);
    }

    @Test
    public void shouldCallPopulateList_whenDataReadyIsCalled() {
        EMPTY_PLANET.setName(PLANET_NAME);
        mockPresenter.onDataReady(mockGetPlanetsResponse);

        verify(mockView).populateList(mockGetPlanetsResponse);
    }

    @Test
    public void shouldCallDisplayError_whenDataIsNull() {
        mockPresenter.onDataReady(NULL_RESPONSE);

        verify(mockView).displayError();
    }

    @Test
    public void shouldCallGetPlanetDetails_whenListItemSelectedIsCalled() {
        mockPresenter.listItemSelected(mockPlanet);

        verify(mockView).openPlanetDetailsActivity(mockPlanet);
    }

    @Test
    public void shouldCallDisplayError_whenPlanetDetailsAreNull() {
        mockPresenter.listItemSelected(null);

        verify(mockView).displayError();
    }
}