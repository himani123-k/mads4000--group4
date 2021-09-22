

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    private String username;
    private String email;
    private String password;
    private ArrayList<Ticket> purchasedTickets;

    public Customer() {
        this.purchasedTickets = new ArrayList<>();
    }

    public Customer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.purchasedTickets = new ArrayList<>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedMovieIDs(ArrayList<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public void welcome(){

        while(true){
            System.out.println("Hello, welcome to the application:\nEnter your login information, or (q) to quit");
            System.out.print("Email address: ");
            Scanner scanner  = new Scanner(System.in);
            String email = scanner.nextLine();

            if(email.equals("q")){
                System.exit(0);
            }else{
                setEmail(email);
                System.out.print("Password: ");
                setPassword(scanner.nextLine());
                this.login();
            }
        }
    }

    public ArrayList<Customer> createUsers(){

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Kamal Preet", "kamalpreet@georgebrown.ca", "gbckamal"));
        customers.add(new Customer("Himani", "himani@georgebrown.ca", "gbchimani"));
        customers.add(new Customer("Jalpa", "jalpa@georgebrown.ca", "gbcjalpa"));

        return customers;
    }

    public void login(){

        for (Customer customer : Main.customers) {
            if(customer.email.equals(this.email) && customer.password.equals(this.password)){
                customer.openUserAccount();
                return;
            }
        }

        System.out.println("Incorrect email or password\n");
        this.welcome();
    }

    public void openUserAccount(){

        System.out.print("\nHello " + this.username + "\n");
        while(true){
            System.out.println("\nWhat do you want to do?\n" +
            "1. See list of all movies\n" +
            "2. View in person movie schedule\n" +
            "3. Buy Tickets\n" +
            "4. View ticket purchase history\n" +
            "5. Watch online movies\n" +
            "6. Logout and return to login screen\n\n" +
            "Enter your choice: ");
            this.selectUserOption();
        }
    }

    public void selectUserOption(){
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1 -> new Movie().displayMovies();
            case 2 -> new InPersonScreening().displayMovies(Main.inPersonMovies);
            case 3 -> new Ticket().purchaseTicket(this);
            case 4 -> new Ticket().viewPurchaseHistory(this);
            case 5 -> new OnlineScreening().watchMovie(this);
            case 6 -> new Customer().welcome();
            default -> System.out.println("Please enter a valid choice");
        }
    }


}
