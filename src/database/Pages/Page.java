package database.Pages;

import input.Action;
import Output.Output;
import database.Database;

public class Page {
    private String name;

    /**
     * returns the name parameter of the class
     *
     * @return a string
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the name parameter
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * this function lets the currnt object to be visited by an visitor
     *
     * @param action        the visitor
     * @param db            the database
     * @param out           the connection to the output file
     * @param currentAction the action to be performed
     */
    public void onPageAction(final OnPageAction action, final Database db, final Output out,
                             final Action currentAction) {
        action.execute(this, db, out, currentAction);
    }

    /**
     * a function that changes the current page
     * @param action the action to be performed
     * @param db the database
     * @param out the connection to the output file
     */
    public void changePageAction(final Action action, final Database db, final Output out) {
        System.out.println("ceva");

    }

}
