
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ticket {
    private int ticketID = 0;
    private LocalDateTime purchaseDate;
    private Movie movie;

    public Ticket() {
    }

    public Ticket(LocalDateTime purchaseDate, Movie movie) {
        this.purchaseDate = purchaseDate;
        this.movie = movie;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void purchaseTicket(Customer customer) {

        System.out.println("Enter Movie ID");
        Scanner scanner = new Scanner(System.in);
        int movieID = scanner.nextInt();

        System.out.println("How many tickets you want to buy?");
        int numberOfTickets = scanner.nextInt();

        for (OnlineScreening movie : Main.onlineMovies) {
            if (movie.getMovieID() == movieID) {
                customer.getPurchasedTickets().add(new Ticket(LocalDateTime.now(), movie));
                return;
            }
        }
        if (numberOfTickets >= 1 && numberOfTickets < 4) {
            for (InPersonScreening movie : Main.inPersonMovies) {
                if (movie.getMovieID() == movieID) {
                    if (numberOfTickets > movie.getCapacity()) {
                        System.out.println("Movie tickets sold out for " + movie.getTitle());
                    } else {
                        Ticket ticket;
                        for (int i = 0; i < numberOfTickets; i++) {
                            ticket = new Ticket(LocalDateTime.now(), movie);
                            customer.getPurchasedTickets().add(ticket);
                        }
                        movie.setCapacity(movie.getCapacity() - numberOfTickets);
                        return;
                    }
                }
            }
        } else if (numberOfTickets < 1) {
            System.out.println("Invalid number entered");
        } else {
            System.out.println("MAx Capacity is 3");
        }

        System.out.println("Please select a different movie");
    }

    public void viewPurchaseHistory(Customer customer) {
        System.out.println("\nTickets Purchased: ");
        // System.out.printf("%-5s %-30s %-15s %s\n", "Title", "Purchase Time");
        for (Ticket ticket : customer.getPurchasedTickets()) {
            if (ticket.movie.isOnline()) {
                System.out.printf("Name: %-30s Director: %-15s Purchase Date: %-15s Runtime: %-15s Is Online: %s\n",
                        ticket.getMovie().getTitle(), ticket.getMovie().getDirector(), ticket.getPurchaseDate(),
                        ticket.getMovie().getRunTime(), ticket.getMovie().isOnline());
            } else {
                for (InPersonScreening movie : Main.inPersonMovies) {
                    if (movie.getMovieID() == ticket.getMovie().getMovieID()) {
                        System.out.printf(
                                "Name: %-30s Director: %-15s Purchase Date: %-15s Runtime: %-15s Address: %-15s Audi: %-15s Is Online: %s\n",
                                movie.getTitle(), movie.getDirector(), ticket.getPurchaseDate(), movie.getRunTime(),
                                movie.getAddress(), movie.getAudi(), movie.isOnline());
                    }
                }
            }
        }
    }
}
