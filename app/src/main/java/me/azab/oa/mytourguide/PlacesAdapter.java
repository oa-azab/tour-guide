package me.azab.oa.mytourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omar on 5/11/2017.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder>{

    private List<Place> mPlaces;
    private Context mContext;

    public PlacesAdapter(Context context, List<Place> places){
        mContext = context;
        mPlaces = places;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_place, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Place place = mPlaces.get(position);

        TextView textView = holder.mText;
        ImageView imageView = holder.mImage;
        TextView textDesciption = holder.mDesciption;
        Button btnDirections = holder.mBtnDirections;
        textView.setText(place.getName());
        imageView.setImageResource(place.getImage());
        textDesciption.setText(place.getDescirption());
        btnDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(place.getLocationUrl()));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mText;
        public ImageView mImage;
        public TextView mDesciption;
        public Button mBtnDirections;

        public ViewHolder(View itemView) {
            super(itemView);

            mText = (TextView) itemView.findViewById(R.id.item_text);
            mImage = (ImageView) itemView.findViewById(R.id.item_image);
            mDesciption = (TextView) itemView.findViewById(R.id.item_descrption);
            mBtnDirections = (Button) itemView.findViewById(R.id.item_btn_directions);
        }
    }
}
