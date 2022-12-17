package Database.Pages;

import Database.Database;
import Input.Action;
import Input.Movie;
import Output.Output;

import java.util.ArrayList;

public class MoviesPage extends Page {

    public MoviesPage() {
        super.name = "movies";
    }

    @Override
    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    public void changePageAction(Action action, Database db, Output out) {
        if (action.getPage().equals(super.name)) {
            db.setCurrentPage(PageFactory.createPage("movies"));
            db.setCurrentMovies(new ArrayList<>());
            db.getCurrentMovies().addAll(db.getMoviesUserCanSee());
            out.addCurrentMovies(db);
            return;}

        if (action.getPage().equals("logout")) {
            db.logout();
            return;
        }
        if (action.getPage().equals("homepage")) {
            db.setCurrentMovies(new ArrayList<>());
            db.setCurrentPage(PageFactory.createPage("homepage"));
            return;
        }
        if (action.getPage().equals("see details")) {

            if (db.movieExists(action.getMovie()) == null) {
                out.addError();
            } else {
                Movie m = db.movieExists(action.getMovie());
                db.setCurrentMovies(new ArrayList<>());
                db.getCurrentMovies().add(m);
                out.addCurrentMovies(db);

            }
                db.setCurrentPage(PageFactory.createPage("see details"));
            return;
        }


        out.addError();
    }
}
