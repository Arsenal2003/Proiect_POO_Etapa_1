package database.Pages;

import input.Action;
import Output.Output;
import database.Database;

import java.util.ArrayList;

public final class HomePage extends Page {

    public HomePage() {
        super.setName("HomePage");
    }

    @Override
    public void onPageAction(final OnPageAction action, final Database db, final Output out,
                             final Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    @Override
    public void changePageAction(final Action action, final Database db, final Output out) {

        if (action.getPage().equals(super.getName())) {
            return;
        }
        if (action.getPage().equals("logout")) {
            db.logout();
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
