import java.util.ArrayList;

public class User {
    private userCredentials credentials;
    private ArrayList<Movie> currentMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> watchedMovies;

    private int numFreePremiumMovies;

    public User(User newUser) {
        credentials = new userCredentials(newUser.getCredentials());
        currentMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
    }

    public User() {
    }

    public userCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(userCredentials credentials) {
        this.credentials = credentials;
    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    public void setCurrentMovies(ArrayList<Movie> currentMovies) {
        this.currentMovies = currentMovies;
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

    @Override
    public String toString() {
        return "User{" +
                "credentials=" + credentials +
                '}';
    }
}
