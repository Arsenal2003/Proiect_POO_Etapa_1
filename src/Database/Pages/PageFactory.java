package Database.Pages;

public class PageFactory {

    public static Page createPage(String pageName){
        switch(pageName){
            case "UAHomePage": return new UAHomePage();
            case "login": return new LoginPage();
            case "register": return new RegisterPage();
            case "homepage": return new HomePage();
            case "movies": return new MoviesPage();
            case "see details": return new SeeDetailsPage();
            case "upgrades": return new UpgradesPage();

            default: System.out.println("Page name was not found");
            return null;
        }

    }
}
