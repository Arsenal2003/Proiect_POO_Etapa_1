package Database.Pages;

import Database.Database;
import Input.Action;
import Output.Output;

public class Page {
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onPageAction(OnPageAction action, Database db, Output out, Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    public void changePageAction(Action action, Database db, Output out) {
        System.out.println("ceva");

    }

}
