package Pages;

public class Page{
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String onPageAction(OnPageAction action){

        return action.execute(this);
    }

}
