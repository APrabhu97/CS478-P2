package com.anish.p2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> movieList = new ArrayList<>();
    RecyclerView nameView;

    //creating a listener to open the url in a browser
    RVClickListener listener = (url) -> {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        MainActivity.this.startActivity(i);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameView = findViewById(R.id.recycler_view);
        setMovieData();

        //creating a custom adapter to handle movieList
        MyAdapter adapter = new MyAdapter(movieList, listener);
        nameView.setHasFixedSize(true);
        nameView.setAdapter(adapter);
        nameView.setLayoutManager(new LinearLayoutManager(this));//setting the default layout manager
    }

    //creating the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean isGridLayout = nameView.getLayoutManager() instanceof GridLayoutManager;
        switch (item.getItemId()) {
            //we only check with gridLayout as gridLayout extends linearLayout and hence is an instance of both
            case R.id.om2:
                //only setting GridLayoutManager if not already set
                if(!isGridLayout) {
                    nameView.setLayoutManager(new GridLayoutManager(this, 2));
                }
                return true;
            case R.id.om1:
                //only setting LinearLayoutManager if gridLayout was set
                if(isGridLayout){
                    nameView.setLayoutManager(new LinearLayoutManager(this));
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //setting the movie data
    void setMovieData(){
        movieList.add(new Movie("The Good, the Bad and the Ugly",
                "Sergio Leone",
                "https://www.imdb.com/video/vi3416964889?playlistId=tt0060196&ref_=tt_pr_ov_vi",
                "https://www.imdb.com/title/tt0060196/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Sergio_Leone",
                R.drawable.good_bad_ugly));
        movieList.add(new Movie("A Dog's Will",
                "Guel Arraes",
                "https://www.youtube.com/watch?v=wDVdgnhiNlY",
                "https://www.imdb.com/title/tt0271383/?ref_=tt_mv_close",
                "https://pt.wikipedia.org/wiki/Guel_Arraes",
                R.drawable.dogs_will));
        movieList.add(new Movie("Once Upon a Time in the West",
                "Sergio Leone",
                "https://www.imdb.com/video/vi239075865?playlistId=tt0064116&ref_=tt_pr_ov_vi",
                "https://www.imdb.com/title/tt0064116/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Sergio_Leone",
                R.drawable.once_upon_time_west));
        movieList.add(new Movie("Django Unchained",
                "Quentin Tarantino",
                "https://www.imdb.com/video/vi2291574553?playlistId=tt1853728&ref_=tt_ov_vi",
                "https://www.imdb.com/title/tt1853728/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Quentin_Tarantino",
                R.drawable.django_unchained));
        movieList.add(new Movie("Unforgiven",
                "Clint Eastwood",
                "https://www.imdb.com/video/vi3445406489?playlistId=tt0105695&ref_=tt_ov_vi",
                "https://www.imdb.com/title/tt0105695/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Clint_Eastwood",
                R.drawable.unforgiven));
        movieList.add(new Movie("Sholay",
                "Ramesh Sippy",
                "https://www.imdb.com/video/vi214219545?playlistId=tt0073707&ref_=tt_ov_vi",
                "https://www.imdb.com/title/tt0073707/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Ramesh_Sippy",
                R.drawable.sholay));
        movieList.add(new Movie("For a Few Dollars More",
                "Sergio Leone",
                "https://www.imdb.com/video/vi773831705?playlistId=tt0059578&ref_=tt_pr_ov_vi",
                "https://www.imdb.com/title/tt0059578/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/Sergio_Leone",
                R.drawable.few_dollars_more));
        movieList.add(new Movie("Butch Cassidy and the Sundance Kid",
                "George Roy Hill",
                "https://www.imdb.com/video/vi2377908505?playlistId=tt0064115&ref_=tt_ov_vi",
                "https://www.imdb.com/title/tt0064115/?ref_=adv_li_tt",
                "https://en.wikipedia.org/wiki/George_Roy_Hill",
                R.drawable.butch_sundance_kid));
    }
}