package database.Pages;

public final class PageFactory {

    /**
     * the factory function that creates the instances of classes
     *
     * @param pageName the page name
     * @return an instance of type pageName
     */
    public static Page createPage(final String pageName) {
        switch (pageName) {
            case "UAHomePage":
                return new UAHomePage();
            case "login":
                return new LoginPage();
            case "register":
                return new RegisterPage();
            case "homepage":
                return new HomePage();
            case "movies":
                return new MoviesPage();
            case "see details":
                return new SeeDetailsPage();
            case "upgrades":
                return new UpgradesPage();

            default:
                System.out.println("Page name was not found");
                return null;
        }

    }
}
