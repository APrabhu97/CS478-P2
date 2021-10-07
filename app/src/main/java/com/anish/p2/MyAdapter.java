package com.anish.p2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movieList;
    private RVClickListener RVlistener;
    private Context context;

    public MyAdapter(List<Movie> movieList, RVClickListener listener){
        this.movieList = movieList;
        this.RVlistener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(listView, RVlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //setting the movie data in the individual view holder
        Movie m = movieList.get(position);
        holder.movieName.setText(m.getName());
        holder.directorName.setText("Dir: "+m.getDirectorName());
        holder.image.setImageResource(m.getThumbnail());
        holder.movie = m;
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

        public TextView movieName;
        public TextView directorName;
        public ImageView image;
        private RVClickListener listener;
        private View itemView;
        private Movie movie;

        public ViewHolder(@NonNull View itemView, RVClickListener passedListener) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            directorName = (TextView) itemView.findViewById(R.id.directorName);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            this.itemView = itemView;
            itemView.setOnCreateContextMenuListener(this); //set context menu for each list item (long click)
            this.listener = passedListener;
            itemView.setOnClickListener(this); //set short click listener
        }

        @Override
        public void onClick(View v) {
            //opening the trailer of the movie on click of movie item
            listener.onClick(movie.getTrailerLink());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.inflate(R.menu.context_menu, menu );

            //setting on click listeners for each item in the context menu
            menu.getItem(0).setOnMenuItemClickListener(onMenu);
            menu.getItem(1).setOnMenuItemClickListener(onMenu);
            menu.getItem(2).setOnMenuItemClickListener(onMenu);
        }

        private final MenuItem.OnMenuItemClickListener onMenu = new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){
                String url = "";
                switch(item.getItemId()){
                    case R.id.cm1:
                        url = movie.getTrailerLink();
                        break;
                    case R.id.cm2:
                        url = movie.getImdbLink();
                        break;
                    case R.id.cm3:
                        url = movie.getDirectorWikipediaLink();
                        break;
                }
                //calling the parent activity's function with the selected URL
                listener.onClick(url);
                return true;
            }
        };



    }
}

