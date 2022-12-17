package database.Pages;

import input.Action;
import Output.Output;
import database.Database;

public final class LoginPage extends Page {

    public LoginPage() {
        super.setName("login");
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
        out.addError();
        db.setCurrentPage(PageFactory.createPage("UAHomePage"));
    }
}
