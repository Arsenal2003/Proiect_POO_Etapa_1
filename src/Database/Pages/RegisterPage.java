package Database.Pages;

import Database.Database;
import Input.Action;
import Output.Output;

public class RegisterPage extends Page {

    public RegisterPage() {
        super.name = "register";
    }

    @Override
    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this,db, out, currentAction);
    }
    @Override
    public void changePageAction(Action action, Database db, Output out) {
        if (action.getPage().equals(super.name)) return;
        out.addError();
        db.setCurrentPage(PageFactory.createPage("UAHomePage"));
    }

}
