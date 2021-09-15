package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;



@Parcel


public class Movie {

    String posterPath, title, overview, backdroppath;
    int movieID;
    double rating;

    // empty constructor needed by the Parceler library
    public Movie() {

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        //get poster_path because inside the API is can poster_path
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdroppath = jsonObject.getString("backdrop_path");
        rating = jsonObject.getDouble("vote_average");
        movieID = jsonObject.getInt("id");
    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length();i++)
        {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public double getRating()
    {
        return rating;
    }
    public int getID() {
        return movieID;
    }
    public  String getbackdroppath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdroppath);
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
