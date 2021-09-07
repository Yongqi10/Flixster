package adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;
import java.util.logging.Level;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    Context context;
    List<Movie> moives;

    public MovieAdapter(Context context, List<Movie> movies)
    {
        this.context = context;
        this.moives = movies;
    }

    @NonNull
    @Override
    //Usually involves inflating a layout from XML and returning the holder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(movieView);
    }

    @Override
    public int getItemCount() {
        return moives.size();
    }

    @Override
    //Involves populating data into the item through holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the moviw at te passed in position
        Movie movie = moives.get(position);
        //bind the movie data into the VH
        holder.bind(movie);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvoverview;
        ImageView ivposter;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvoverview = itemView.findViewById(R.id.tvOverveiw);
            ivposter = itemView.findViewById(R.id.ivposter);
        }
        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvoverview.setText(movie.getOverview());

            String imageURL;
            //if phone is in landscape
            //then imageURL = back drop image
            //else image = poster image
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                imageURL = movie.getbackdroppath();
            }
            else
            {
                imageURL = movie.getPosterPath();
            }
            Glide.with(context).load(imageURL).into(ivposter);
        }

    }
}
