package Database.Pages;

import Input.Action;
import Input.userCredentials;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.stream.Collectors.toCollection;

public class ExecuteOnPage implements OnPageAction {


    @Override
    public void execute(Page page, Database.Database db, Output.Output out, Action action) {
        System.out.println("??? esti dus ai uitat sa adaugi si in interfata  ???");
    }

    @Override
    public void execute(UAHomePage page, Database.Database db, Output.Output out, Action action) {
        out.addError();
    }

    @Override
    public void execute(HomePage page, Database.Database db, Output.Output out, Action action) {
        out.addError();
    }

    @Override
    public void execute(RegisterPage page, Database.Database db, Output.Output out, Action action) {
        if (action.getFeature().equals("register")) {
            if (db.findUser(action.getCredentials().getName()) == null) {
                db.addUser(action.getCredentials());
                db.setCurrentUser(db.findUser(action.getCredentials().getName()));
                out.addLoginSuccess(db);
                db.setCurrentPage(PageFactory.createPage("homepage"));
            } else {
                db.setCurrentPage(PageFactory.createPage("UAHomePage"));
                out.addError();
            }

        } else {
            db.setCurrentPage(PageFactory.createPage("UAHomePage"));
            out.addError();
        }
    }

    @Override
    public void execute(LoginPage page, Database.Database db, Output.Output out, Action action) {

        if (action.getFeature().equals("login")) {
            if (db.userLoginOk(action.getCredentials().getName(), action.getCredentials().getPassword())) {
                db.setCurrentUser(db.findUser(action.getCredentials().getName()));
                out.addLoginSuccess(db);
                db.setCurrentPage(PageFactory.createPage("homepage"));
            } else {
                db.setCurrentPage(PageFactory.createPage("UAHomePage"));
                out.addError();
            }

        } else {
            db.setCurrentPage(PageFactory.createPage("UAHomePage"));
            out.addError();
        }
    }

    public void execute(MoviesPage page, Database.Database db, Output.Output out, Action action) {
        db.setCurrentMovies(new ArrayList<>());
        db.getCurrentMovies().addAll(db.getMoviesUserCanSee());
        db.setCurrentMovies(db.getCurrentMovies().stream().distinct().collect(toCollection(ArrayList::new)));
        if (action.getFeature().equals("search")) {

            for (int i = 0; i < db.getCurrentMovies().size(); i++) {
                if (!db.getCurrentMovies().get(i).getName().contains(action.getStartsWith())) {
                    db.getCurrentMovies().remove(i);
                    i--;
                }

            }
            out.addCurrentMovies(db);
            db.setCurrentMovies(new ArrayList<>());
            return;
        }
        if (action.getFeature().equals("filter")) {

            //System.out.println(action.getFilters());

            if (action.getFilters().getContains() != null) {
                // delete from current movies the ones that don't have the needed criteria

                if (action.getFilters().getContains().getActors() != null) {
                    for (int i = 0; i < action.getFilters().getContains().getActors().size(); i++) {
                        for (int j = 0; j < db.getCurrentMovies().size(); j++) {
                            if (!db.getCurrentMovies().get(j).getActors().contains(action.getFilters().getContains().getActors().get(i))) {
                                db.getCurrentMovies().remove(j);
                                j--;
                            }
                        }
                    }
                }
                if (action.getFilters().getContains().getGenre() != null) {
                    for (int i = 0; i < action.getFilters().getContains().getGenre().size(); i++) {
                        for (int j = 0; j < db.getCurrentMovies().size(); j++) {
                            if (!db.getCurrentMovies().get(j).getGenres().contains(action.getFilters().getContains().getGenre().get(i))) {
                                db.getCurrentMovies().remove(j);
                                j--;
                            }
                        }
                    }

                }


            }

            if (action.getFilters().getSort() != null) {

                if (action.getFilters().getSort().getDuration() != null) {
                    if (action.getFilters().getSort().getDuration().equals("decreasing")) {
                        Collections.sort(db.getCurrentMovies(), (o1, o2) -> Integer.compare(o1.getDuration(), o2.getDuration()));
                    } else {
                        Collections.sort(db.getCurrentMovies(), (o1, o2) -> Integer.compare(o2.getDuration(), o1.getDuration()));
                    }

                }

                if (action.getFilters().getSort().getRating() != null) {
                    if (action.getFilters().getSort().getRating().equals("decreasing")) {
                        Collections.sort(db.getCurrentMovies(), (o1, o2) -> Double.compare(o1.getRating(), o2.getRating()));

                    } else {
                        Collections.sort(db.getCurrentMovies(), (o1, o2) -> Double.compare(o2.getRating(), o1.getRating()));

                    }

                }

            }
            out.addCurrentMovies(db);
            db.setCurrentMovies(new ArrayList<>());
            return;
        }
        out.addError();
    }

    public void execute(UpgradesPage page, Database.Database db, Output.Output out, Action action) {
        if (action.getFeature().equals("buy tokens")){
            if(db.getCurrentUser().getCredentials().getBalance() - action.getCount() >= 0){
                db.getCurrentUser().getCredentials().setBalance(db.getCurrentUser().getCredentials().getBalance() - action.getCount());
                db.getCurrentUser().getCredentials().setToken(db.getCurrentUser().getCredentials().getToken()+action.getCount());

            }else{
                out.addError();
            }
          return;
        }
        if (action.getFeature().equals("buy premium account")){
            if(db.getCurrentUser().getCredentials().getToken() - 10 >= 0){
                db.getCurrentUser().getCredentials().setToken(db.getCurrentUser().getCredentials().getToken() - 10);
                db.getCurrentUser().getCredentials().setAccountType(userCredentials.AccType.premium);
            }else{
                out.addError();
            }
            return;
        }
        out.addError();
    }

    public void execute(SeeDetailsPage page, Database.Database db, Output.Output out, Action action) {
    }
}
