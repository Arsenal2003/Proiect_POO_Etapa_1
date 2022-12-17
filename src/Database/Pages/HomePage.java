package Database.Pages;

import Database.Database;
import Input.Action;
import Output.Output;

public class HomePage extends Page {

    public HomePage() {
        super.name = "HomePage";
    }

    @Override
    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    @Override
    public void changePageAction(Action action, Database db, Output out) {

        if (action.getPage().equals(super.name)) return;
        if (action.getPage().equals("logout")) {
            db.logout();
            return;
        }
        if (action.getPage().equals("movies")) {
            db.setCurrentPage(PageFactory.createPage("movies"));
            db.getCurrentMovies().addAll(db.getMoviesUserCanSee());
            out.addCurrentMovies(db);
            return;
        }
        if (action.getPage().equals("upgrades")) {

            //db.setCurrentMovies(new ArrayList<>());
            //db.setCurrentPage(PageFactory.createPage("upgrades"));
            return;
        }


        out.addError();

    }
}
