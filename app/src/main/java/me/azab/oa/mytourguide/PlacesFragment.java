package me.azab.oa.mytourguide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    RecyclerView mRecyclerView;
    PlacesAdapter mPlacesAdapter;

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.places_recycler_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Place> list = new ArrayList<>();
        list.add(new Place(getString(R.string.rosto_name),R.drawable.rostoimage,getString(R.string.rosto_description),getString(R.string.rosto_location_url)));
        list.add(new Place(getString(R.string.kababji_name),R.drawable.kababjiimage,getString(R.string.kababji_description),getString(R.string.kababji_location_url)));

        mPlacesAdapter = new PlacesAdapter(getContext(),list);
        mRecyclerView.setAdapter(mPlacesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
    }
}
