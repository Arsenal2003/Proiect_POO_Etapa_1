package Input;

import Output.Output;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class userCredentials {
    private String name;
    private String password;
    private AccType accountType;
    private String country;
    private int balance;
    private int token = 0;


    enum AccType{
        standard,
        premium
    }

    public userCredentials(userCredentials newUserCred) {
        name = newUserCred.name;
        password = newUserCred.password;
        token = newUserCred.token;
        accountType = newUserCred.accountType;
        country = newUserCred.country;
        balance = newUserCred.balance;
    }

    public userCredentials() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccType accountType) {
        this.accountType = accountType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getToken() {
        return token;
    }
    public ObjectNode outputToJson(){
        ObjectNode uc = Output.objectMapper.createObjectNode();
        uc.putPOJO("name",name);
        uc.putPOJO("password",password);
        uc.putPOJO("accountType",accountType);
        uc.putPOJO("country",country);
        uc.putPOJO("balance",String.valueOf(balance));
        return uc;
    }

    @Override
    public String toString() {
        return "InpuClasses.userCredentials{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", country='" + country + '\'' +
                ", balance=" + balance +
                ", token=" + token +
                '}';
    }
}
