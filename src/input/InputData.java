package input;

import java.util.ArrayList;

public final class InputData {

    public static int premiumACC = 10;
    private ArrayList<User> users;
    private ArrayList<Movie> movies;
    private ArrayList<Action> actions;

    public static int getPremiumACC() {
        return premiumACC;
    }

    public static void setPremiumACC(final int premiumACC) {
        InputData.premiumACC = premiumACC;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(final ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(final ArrayList<Action> actions) {
        this.actions = actions;
    }


}
