import Database.Database;
import Database.Pages.ExecuteOnPage;
import Database.Pages.PageFactory;
import Input.InputData;
import Input.Movie;
import Input.User;
import Output.Output;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        // reading the input from the json file
        InputData input = Output.objectMapper.readValue(new File(args[0]), InputData.class);
        Output out = new Output();

        Database PooTvDataBase = new Database(PageFactory.createPage("UAHomePage"));

        // populating the database with the users and movies
        for (int i = 0; i < input.getUsers().size(); i++) {
            PooTvDataBase.getUsers().add(new User(input.getUsers().get(i)));
        }
        for (int i = 0; i < input.getMovies().size(); i++) {
            PooTvDataBase.getMovies().add(new Movie(input.getMovies().get(i)));
        }

        // iterating throw the actions vector
        for (int i = 0; i < input.getActions().size(); i++) {

            //System.out.println(PooTvDataBase.getCurrentPage().getClass().getName());

            ExecuteOnPage pageVisitor = new ExecuteOnPage();
            if (input.getActions().get(i).getType().equals("on page")) {
                PooTvDataBase.getCurrentPage().onPageAction(pageVisitor, PooTvDataBase, out, input.getActions().get(i));

            } else {
                if (input.getActions().get(i).getType().equals("change page")) {
                    PooTvDataBase.getCurrentPage().changePageAction(input.getActions().get(i), PooTvDataBase, out);
                }
            }
        }

        ObjectWriter objectWriter = Output.objectMapper.writerWithDefaultPrettyPrinter();
        try {
            objectWriter.writeValue(new File(args[1]), out.getOutputFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
