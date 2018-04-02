package com.percival.beth.planetapp.ui.planetlist;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.percival.beth.planetapp.R;
import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetListActivity extends AppCompatActivity implements IPlanetListView {
    @BindView(R.id.root_view)
    ConstraintLayout rootView;
    @BindView(R.id.recycler_view_planets)
    RecyclerView recyclerView;

    private IPlanetListPresenter presenter;
    private PlanetListRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_list);
        ButterKnife.bind(this);
        presenter = new PlanetListPresenter(this, new PlanetListData());
        initialiseRecyclerView();
        presenter.onViewReady();
    }

    @Override
    public void populateList(final GetPlanetsResponse getPlanetsResponse) {
        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new PlanetListRecyclerAdapter(getPlanetsResponse, presenter, getBaseContext()));
                    }
                }

        );
    }

    @Override
    public void displayError() {
        Snackbar snackbar = Snackbar
                .make(rootView, getBaseContext().getString(R.string.error_generic_try_again_later), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void openPlanetDetailsActivity(Planet planet) {
//        Intent intent = new Intent(this, PlanetDetailsActivity.class);
//        intent.putExtra(EXTRA_PLANET, planet);
//        startActivity(intent);
    }

    private void initialiseRecyclerView() {
        adapter = new PlanetListRecyclerAdapter(null, presenter, getBaseContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
