package Input;

import Output.Output;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public class User {
    private userCredentials credentials;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> watchedMovies;

    private int numFreePremiumMovies = 15;

    public User(User newUser) {
        credentials = new userCredentials(newUser.getCredentials());
        purchasedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
    }

    public User() {
        purchasedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
    }

    public userCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(userCredentials credentials) {
        this.credentials = credentials;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ObjectNode outputToJson() {
        ObjectNode usernode = Output.objectMapper.createObjectNode();
        usernode.putPOJO("credentials",credentials.outputToJson());
        usernode.putPOJO("tokensCount",credentials.getToken());
        usernode.putPOJO("numFreePremiumMovies", numFreePremiumMovies );
        usernode.putPOJO("purchasedMovies",purchasedMovies);
        usernode.putPOJO("watchedMovies",watchedMovies);
        usernode.putPOJO("likedMovies",likedMovies);
        usernode.putPOJO("ratedMovies",ratedMovies);


        return usernode;
    }

    @Override
    public String toString() {
        return "InpuClasses.User{" +
                "credentials=" + credentials +
                '}';
    }
}
