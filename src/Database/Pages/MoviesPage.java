package Database.Pages;

import Database.Database;
import Input.Action;
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



        out.addError();
    }
}
