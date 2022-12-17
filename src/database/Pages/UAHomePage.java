package database.Pages;


import input.Action;
import Output.Output;
import database.Database;


public final class UAHomePage extends Page {

    public UAHomePage() {
        super.setName("UAHomePage");
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
        if (action.getPage().equals("register") || action.getPage().equals("login")) {
            db.setCurrentPage(PageFactory.createPage(action.getPage()));

        } else {
            out.addError();
        }

    }
}
