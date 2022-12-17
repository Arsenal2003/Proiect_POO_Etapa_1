package database.Pages;

import input.Action;
import Output.Output;
import database.Database;

import java.util.ArrayList;

public final class UpgradesPage extends Page {

    public UpgradesPage() {
        super.setName("upgrades");
    }

    @Override
    public void onPageAction(final OnPageAction action, final Database db, final Output out,
                             final Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    /**
     * changes the current page in logout/homepage/movies
     *
     * @param action the action to be performed
     * @param db     the database
     * @param out    the connection to the output file
     */
    public void changePageAction(final Action action, final Database db, final Output out) {
        if (action.getPage().equals(super.getName())) {
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
        out.addError();
    }

}
