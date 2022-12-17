package Database.Pages;

import Database.Database;
import Input.Action;
import Output.Output;

public interface OnPageAction {
    public void execute(Page page, Database db, Output out, Action action);
    public void execute(UAHomePage page, Database db, Output out, Action action);
    public void execute(HomePage page, Database db, Output out, Action action);
    public void execute(RegisterPage page, Database db, Output out, Action action);
    public void execute(LoginPage page, Database db, Output out, Action action);
    public void execute(MoviesPage page, Database db, Output out, Action action);

    //public void execute(UpgradesPage page, Database db, Output out, Action action);
    //public void execute(SeeDetailsPage page, Database db, Output out, Action action);


}
