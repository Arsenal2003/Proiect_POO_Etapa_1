package database.Pages;

import input.Action;
import Output.Output;
import database.Database;

public interface OnPageAction {
    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(Page page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(UAHomePage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(HomePage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(RegisterPage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(LoginPage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(MoviesPage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(UpgradesPage page, Database db, Output out, Action action);

    /**
     * This function performs the action specified on the database
     *
     * @param page   the current page of the database
     * @param db     the database
     * @param out    the connection to the output file
     * @param action the action to perform
     */
    void execute(SeeDetailsPage page, Database db, Output out, Action action);


}
