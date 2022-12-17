package Database.Pages;

import Database.Database;
import Input.Action;
import Output.Output;

import java.util.ArrayList;

public class UpgradesPage extends Page{

    public UpgradesPage() {
        super.name = "upgrades";
    }

    @Override
    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    public void changePageAction(Action action, Database db, Output out) {
        if (action.getPage().equals(super.name)) return;

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
