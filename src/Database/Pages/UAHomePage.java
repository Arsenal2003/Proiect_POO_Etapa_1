package Database.Pages;


import Database.Database;
import Input.Action;
import Output.Output;


public class UAHomePage extends Page{

    public UAHomePage() {
        super.name  = "UAHomePage";
    }

    @Override
    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this,db, out, currentAction);
    }

    @Override
    public void changePageAction(Action action, Database db, Output out) {
        if (action.getPage().equals(super.name)) return;
        if(action.getPage().equals("register") || action.getPage().equals("login")){
            db.setCurrentPage(PageFactory.createPage(action.getPage()));

        }else{
            out.addError();
        }

    }
}
