package input;

import Output.Output;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public final class User {
    private userCredentials credentials;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> watchedMovies;

    private int numFreePremiumMovies = 15;

    public User(final User newUser) {
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

    public void setCredentials(final userCredentials credentials) {
        this.credentials = credentials;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }


    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ArrayNode getCurrentMoviesToJson(final ArrayList<Movie> movies) {
        ArrayNode outmovies = Output.objectMapper.createArrayNode();
        for (int i = 0; i < movies.size(); i++) {
            outmovies.add(movies.get(i).printToJson());

        }
        return outmovies;
    }


    public ObjectNode outputToJson() {
        ObjectNode usernode = Output.objectMapper.createObjectNode();
        usernode.putPOJO("credentials", credentials.outputToJson());
        usernode.putPOJO("tokensCount", credentials.getToken());
        usernode.putPOJO("numFreePremiumMovies", numFreePremiumMovies);
        usernode.putPOJO("purchasedMovies", getCurrentMoviesToJson(purchasedMovies));
        usernode.putPOJO("watchedMovies", getCurrentMoviesToJson(watchedMovies));
        usernode.putPOJO("likedMovies", getCurrentMoviesToJson(likedMovies));
        usernode.putPOJO("ratedMovies", getCurrentMoviesToJson(ratedMovies));


        return usernode;
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }


}
