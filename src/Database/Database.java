package Database;

import Database.Pages.Page;
import Database.Pages.PageFactory;
import Input.Movie;
import Input.User;
import Input.userCredentials;
import Output.Output;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class Database {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Movie> moviesUserCanSee = new ArrayList<>();
    ArrayList<Movie> currentMovies = new ArrayList<>();
    Page currentPage;
    User currentUser;

    public Database(Page currentPage) {
        this.currentPage = currentPage;
        this.currentUser = null;
    }

    public Database() {

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;

    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    public void setCurrentMovies(ArrayList<Movie> currentMovies) {
        this.currentMovies = currentMovies;
    }

    public ArrayList<Movie> getMoviesUserCanSee() {
        return moviesUserCanSee;
    }

    public void setMoviesUserCanSee(ArrayList<Movie> moviesUserCanSee) {
        this.moviesUserCanSee = moviesUserCanSee;
    }

    public void setMoviesUserCanSee() {
        if (currentUser != null) {
            for (int i = 0; i < movies.size(); i++) {
                if (!movies.get(i).getCountriesBanned().contains(currentUser.getCredentials().getCountry())) {
                    moviesUserCanSee.add(movies.get(i));
                }
            }
        }
    }

    public ArrayNode getCurrentMoviesToJson() {
        ArrayNode movies = Output.objectMapper.createArrayNode();
        for (int i = 0; i < currentMovies.size(); i++) {
            movies.add(currentMovies.get(i).printToJson());

        }
        return movies;
    }

    public boolean userLoginOk(String name, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(name)) {
                if (users.get(i).getCredentials().getPassword().equals(password)) {
                    return true;
                }
            }

        }
        return false;
    }


    public User findUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    public void logout() {
        currentPage = PageFactory.createPage("UAHomePage");
        currentUser = null;
        currentMovies = new ArrayList<>();
        moviesUserCanSee = new ArrayList<>();
    }

    public Movie movieExists(String name) {
        for (int i = 0; i < moviesUserCanSee.size(); i++) {
            if (moviesUserCanSee.get(i).getName().equals(name))
                return moviesUserCanSee.get(i);

        }
        return null;
    }

    public void reCalulateRating(Movie m) {
        int nrpers = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRatedMovies().contains(m)) {
                nrpers++;
            }

        }
        m.setRating(m.getRatingSemiTotal() / nrpers);
    }


    public void addUser(userCredentials uc) {
        User newuser = new User();
        newuser.setCredentials(new userCredentials(uc));
        users.add(newuser);
    }
}
