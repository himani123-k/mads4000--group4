

import java.util.ArrayList;

public class Main {

    static ArrayList<Customer> customers;
    static ArrayList<OnlineScreening> onlineMovies;
    static ArrayList<InPersonScreening> inPersonMovies;

    public static void main(String[] args){

        customers = new Customer().createUsers();
        onlineMovies = new OnlineScreening().createMovies();
        inPersonMovies = new InPersonScreening().createMovies();

        new Customer().welcome();
    }
}
