package com.example.startrek_recyclerview;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView image;
        public RatingBar rb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.epTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.epDescription);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            rb = (RatingBar) itemView.findViewById(R.id.epRating);
        }
    }

    private List<Episodes> myEpisodes;

    public EpisodesAdapter(List<Episodes> episodes){
        myEpisodes = episodes;
    }

    @NonNull
    @Override
    public EpisodesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View episodeView = inflater.inflate(R.layout.item_episode, parent, false);
        ViewHolder viewHolder = new ViewHolder(episodeView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesAdapter.ViewHolder holder, int position) {
        //populating the episodeView
        Episodes episode = myEpisodes.get(position);

        //set views
        TextView title = holder.tvTitle;
        title.setText(episode.getTitle());

        TextView description = holder.tvDescription;
        description.setText(episode.getDescription());

        ImageView im = holder.image;
        im.setImageResource(episode.getImage());

        RatingBar rating = holder.rb;
        rating.setRating(episode.getRating());
    }

    @Override
    public int getItemCount() {
        return myEpisodes.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

}
