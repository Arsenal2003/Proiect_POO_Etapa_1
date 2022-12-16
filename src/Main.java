import Pages.PageFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode(); // where the output of the test will be stored

        // reading the input from the json file
        InputData input = objectMapper.readValue(new File(args[0]),InputData.class);

        Database PooTvDataBase = new Database(PageFactory.createPage("UAHomePage"));

        // populating the database with the users and movies
        for(int i=0;i<input.getUsers().size();i++)
                PooTvDataBase.getUsers().add(new User(input.getUsers().get(i)));
        for(int i=0;i<input.getMovies().size();i++)
            PooTvDataBase.getMovies().add(new Movie(input.getMovies().get(i)));


        // iterating throw the actions vector
        for(int i = 0; i<input.getActions().size();i++){
            input.getActions().get(i).getType();


        }





        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        try {
            objectWriter.writeValue(new File(args[1]), output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
