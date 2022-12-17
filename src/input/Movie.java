package input;

import Output.Output;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public final class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private double rating;
    private int numLikes;
    private int numRatings;

    private double ratingSemiTotal = 0.0;

    public Movie(final Movie newMovie) {
        name = newMovie.name;
        year = newMovie.year;
        duration = newMovie.duration;
        genres = new ArrayList<>();
        genres.addAll(newMovie.getGenres());
        actors = new ArrayList<>();
        actors.addAll(newMovie.getActors());
        countriesBanned = new ArrayList<>();
        countriesBanned.addAll(newMovie.getCountriesBanned());
        rating = 0.0;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public double getRatingSemiTotal() {
        return ratingSemiTotal;
    }

    public void setRatingSemiTotal(final double ratingSemiTotal) {
        this.ratingSemiTotal = ratingSemiTotal;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public ObjectNode printToJson() {
        ObjectNode movie = Output.objectMapper.createObjectNode();
        movie.putPOJO("name", name);
        movie.putPOJO("year", year);
        movie.putPOJO("duration", duration);
        movie.putPOJO("genres", genres);
        movie.putPOJO("actors", actors);
        movie.putPOJO("countriesBanned", countriesBanned);
        movie.putPOJO("numLikes", numLikes);
        movie.putPOJO("rating", rating);
        movie.putPOJO("numRatings", numRatings);


        return movie;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }


}
