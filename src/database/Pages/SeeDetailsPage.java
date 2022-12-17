package database.Pages;

import input.Action;
import input.Movie;
import Output.Output;
import database.Database;

import java.util.ArrayList;

public final class SeeDetailsPage extends Page {
    public SeeDetailsPage() {
        super.setName("see details");
    }

    @Override
    public void onPageAction(final OnPageAction action, final Database db, final Output out,
                             final Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    /**
     * changes the current page to see details/logout/homepage/upgrades
     * @param action the action to be performed
     * @param db the database
     * @param out the connection to the output file
     */
    public void changePageAction(final Action action, final Database db, final Output out) {
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
        if (action.getPage().equals("logout")) {
            db.logout();
            return;
        }
        if (action.getPage().equals("homepage")) {
            db.setCurrentMovies(new ArrayList<>());
            db.setCurrentPage(PageFactory.createPage("homepage"));
            return;
        }
        if (action.getPage().equals("movies")) {
            db.setCurrentPage(PageFactory.createPage("movies"));
            db.setCurrentMovies(new ArrayList<>());
            db.getCurrentMovies().addAll(db.getMoviesUserCanSee());
            out.addCurrentMovies(db);
            return;
        }
        if (action.getPage().equals("upgrades")) {
            db.setCurrentMovies(new ArrayList<>());
            db.setCurrentPage(PageFactory.createPage("upgrades"));
            return;
        }
        out.addError();
    }
}
