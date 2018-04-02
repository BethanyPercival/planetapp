package com.percival.beth.planetapp.ui.planetlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.percival.beth.planetapp.R;
import com.percival.beth.planetapp.model.Planet;
import com.percival.beth.planetapp.network.response.GetPlanetsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetListRecyclerAdapter extends RecyclerView.Adapter<PlanetListRecyclerAdapter.ViewHolder> {

    private List<Planet> planetList;
    private IPlanetListPresenter presenter;
    private Context context;

    public PlanetListRecyclerAdapter(GetPlanetsResponse getPlanetsResponse, IPlanetListPresenter presenter, Context context) {
        this.planetList = getPlanetsResponse.getPlanets();
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_planet_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Planet planet = planetList.get(position);
        holder.setPlanetName(planet.getName());
        holder.setImageViewPlanet(planet.getImageUrl());
        holder.constraintLayoutRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.listItemSelected(planet);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (planetList != null) {
            return planetList.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view_planet)
        ImageView imageViewPlanet;
        @BindView(R.id.text_view_planet_name)
        TextView textViewPlanetName;
        @BindView(R.id.root_view)
        ConstraintLayout constraintLayoutRootView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setPlanetName(String planetName) {
            this.textViewPlanetName.setText(planetName);
        }

        public void setImageViewPlanet(String imageUrl) {
            Picasso.get().load(imageUrl).into(imageViewPlanet);
        }
    }
}
