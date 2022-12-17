package Output;

import Database.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class Output {
    public static ObjectMapper objectMapper = new ObjectMapper();
    private ArrayNode outputFile;

    public Output() {
        outputFile = objectMapper.createArrayNode();

    }

    public ArrayNode getOutputFile() {
        return outputFile;
    }

    public void addError() {
        ObjectNode err = objectMapper.createObjectNode();
        err.putPOJO("error", "Error");
        err.putPOJO("currentMoviesList", new ArrayList<>());
        err.putPOJO("currentUser", null);
        outputFile.addPOJO(err);

    }

    public void addLoginSuccess(Database db) {
        db.setCurrentMovies(new ArrayList<>());
        db.setMoviesUserCanSee(new ArrayList<>());
        db.setMoviesUserCanSee();
        ObjectNode login = objectMapper.createObjectNode();
        login.putPOJO("error", null);
        login.putPOJO("currentMoviesList", db.getCurrentMoviesToJson());
        login.putPOJO("currentUser", db.getCurrentUser().outputToJson());
        outputFile.addPOJO(login);

    }
    public void addCurrentMovies(Database db) {
        db.setMoviesUserCanSee();
        db.setCurrentMovies(db.getCurrentMovies().stream().distinct().collect(toCollection(ArrayList::new)));
        ObjectNode movies = objectMapper.createObjectNode();
        movies.putPOJO("error", null);
        movies.putPOJO("currentMoviesList", db.getCurrentMoviesToJson());
        movies.putPOJO("currentUser", db.getCurrentUser().outputToJson());
        outputFile.addPOJO(movies);

    }

}
