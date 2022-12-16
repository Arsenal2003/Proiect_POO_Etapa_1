package Pages;

public interface OnPageAction {
    public String execute(Page page);
    public String execute(UAHomePage page);
    public String execute(LoginPage page);
    public String execute(RegisterPage page);
    public String execute(HomePage page);

}
