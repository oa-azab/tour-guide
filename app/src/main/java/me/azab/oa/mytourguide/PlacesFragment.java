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
    List<Place> mList = new ArrayList<>();

    public static final int MALLS_INDEX = 1;
    public static final int RESTAURANTS_INDEX = 2;
    public static final int CINEMA_INDEX = 3;

    public PlacesFragment() {
        // Required empty public constructor
    }

    public static PlacesFragment newInstance(int index) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
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

        Bundle args = getArguments();
        int index = args.getInt("index", 1);

        mPlacesAdapter = new PlacesAdapter(getContext(), getList(index));
        mRecyclerView.setAdapter(mPlacesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
    }

    private List<Place> getList(int index) {
        List<Place> list = new ArrayList<>();
        switch (index){
            case MALLS_INDEX:
                list.add(new Place(getString(R.string.moa_name), R.drawable.moaimage, getString(R.string.moa_description), getString(R.string.moa_location_url)));
                list.add(new Place(getString(R.string.moe_name), R.drawable.moeiamge, getString(R.string.moe_description), getString(R.string.moe_location_url)));
                break;
            case RESTAURANTS_INDEX:
                list.add(new Place(getString(R.string.rosto_name), R.drawable.rostoiamge, getString(R.string.rosto_description), getString(R.string.rosto_location_url)));
                list.add(new Place(getString(R.string.kababji_name), R.drawable.kababjiimage, getString(R.string.kababji_description), getString(R.string.kababji_location_url)));
                break;
            case CINEMA_INDEX:
                list.add(new Place(getString(R.string.galaxy_name), R.drawable.galaxyimage, getString(R.string.galaxy_description), getString(R.string.galaxy_location_url)));
                break;
        }
        return list;
    }
}
