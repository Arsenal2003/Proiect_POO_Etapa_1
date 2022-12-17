package database;

import input.Movie;
import input.User;
import input.userCredentials;
import Output.Output;
import com.fasterxml.jackson.databind.node.ArrayNode;
import database.Pages.Page;
import database.Pages.PageFactory;

import java.util.ArrayList;

public final class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Movie> moviesUserCanSee = new ArrayList<>();
    private ArrayList<Movie> currentMovies = new ArrayList<>();
    private Page currentPage;
    private User currentUser;

    public Database(final Page currentPage) {
        this.currentPage = currentPage;
        this.currentUser = null;
    }

    public Database() {

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

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final Page currentPage) {
        this.currentPage = currentPage;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;

    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    public void setCurrentMovies(final ArrayList<Movie> currentMovies) {
        this.currentMovies = currentMovies;
    }

    public ArrayList<Movie> getMoviesUserCanSee() {
        return moviesUserCanSee;
    }

    public void setMoviesUserCanSee(final ArrayList<Movie> moviesUserCanSee) {
        this.moviesUserCanSee = moviesUserCanSee;
    }

    /**
     * puts all the movies a user can see in the array list moviesUserCanSee
     */
    public void setMoviesUserCanSee() {
        if (currentUser != null) {
            for (int i = 0; i < movies.size(); i++) {
                if (!movies.get(i).getCountriesBanned()
                        .contains(currentUser.getCredentials().getCountry())) {
                    moviesUserCanSee.add(movies.get(i));
                }
            }
        }
    }

    /**
     * formats an arraylist of type movie to be printed to json
     *
     * @return an array node
     */
    public ArrayNode getCurrentMoviesToJson() {
        ArrayNode moviesToJson = Output.objectMapper.createArrayNode();
        for (int i = 0; i < currentMovies.size(); i++) {
            moviesToJson.add(currentMovies.get(i).printToJson());

        }
        return moviesToJson;
    }

    /**
     * checks the credentials of a user
     *
     * @param name     the name of the user
     * @param password the password of the user
     * @return true if the credentials are ok, false otherwise
     */
    public boolean userLoginOk(final String name, final String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(name)) {
                if (users.get(i).getCredentials().getPassword().equals(password)) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * searches for a user with the specified name
     *
     * @param name of the user
     * @return the user if it's found, null otherwise
     */
    public User findUser(final String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * logs out of the database the current user
     */
    public void logout() {
        currentPage = PageFactory.createPage("UAHomePage");
        currentUser = null;
        currentMovies = new ArrayList<>();
        moviesUserCanSee = new ArrayList<>();
    }

    /**
     * checks if the movie exists in the moviesUserCanSee list
     *
     * @param name of the movie
     * @return the movie if it's found, null otherwise
     */
    public Movie movieExists(final String name) {
        for (int i = 0; i < moviesUserCanSee.size(); i++) {
            if (moviesUserCanSee.get(i).getName().equals(name)) {
                return moviesUserCanSee.get(i);
            }

        }
        return null;
    }

    /**
     * recalculates the rating of a movie
     *
     * @param m the movie to recalculate the rating for
     */
    public void reCalulateRating(final Movie m) {
        int nrpers = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRatedMovies().contains(m)) {
                nrpers++;
            }

        }
        m.setRating(m.getRatingSemiTotal() / nrpers);
    }

    /**
     * adds a user to the current database
     *
     * @param uc the users credentials
     */
    public void addUser(final userCredentials uc) {
        User newuser = new User();
        newuser.setCredentials(new userCredentials(uc));
        users.add(newuser);
    }
}
