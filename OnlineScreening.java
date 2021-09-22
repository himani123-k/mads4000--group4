

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineScreening extends Movie {
    private String movieUrl;

    public OnlineScreening() {
    }

    public OnlineScreening(String movieUrl, int movieID, String title, String director,
                           String description, String genre, LocalTime time, boolean isOnline) {

        super(movieID, title, director, description, genre, time, isOnline);
        this.movieUrl = movieUrl;
    }

    public String getMovieUrl() {
        return this.movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public ArrayList<OnlineScreening> createMovies(){
        ArrayList<OnlineScreening> movies = new ArrayList<>();

        movies.add(new OnlineScreening("", movies.size(),
                "The Dark Knight", "Christopher Nolan",
                "After Gordon, Dent and Batman begin an assault on Gotham's organised crime, the mobs hire " +
                        "the Joker, a psychopathic criminal mastermind who offers to kill Batman and bring the city to its knees.",
                "Action/Adventure", LocalTime.of(2, 32), true));

        movies.add(new OnlineScreening("", movies.size(),"Zindagi Na Milegi Dobara", "Zoya Akhtar",
                "Friends Kabir, Imran and Arjun take a vacation in Spain before Kabir's marriage. The trip " +
                        "turns into an opportunity to mend fences, heal wounds, fall in love with life and combat their worst fears.",
                "Romance/Adventure", LocalTime.of(2, 33), true));

        return movies;
    }

    public void displayMovies(ArrayList<OnlineScreening> movies){

        System.out.println("\nOnline Movies: ");
        System.out.printf("%-5s %-30s %s\n", "ID", "Title", "Runtime");
        for (OnlineScreening movie: movies) {
            System.out.printf("%-5s %-30s %s\n", movie.getMovieID(),
                    movie.getTitle(), movie.getRunTime());
        }
    }

    public void watchMovie(Customer customer){
        boolean hasPurchasedOnlineMovies = false;
        for (Ticket ticket: customer.getPurchasedTickets()) {
            if(ticket.getMovie().isOnline()){
                hasPurchasedOnlineMovies = true;
                System.out.printf("%-5s %-30s %-15s\n", ticket.getMovie().getMovieID(),
                        ticket.getMovie().getTitle(), ticket.getMovie().getRunTime());
            }
        }

        if(hasPurchasedOnlineMovies){
            System.out.println("Enter Movie ID");
            Scanner scanner = new Scanner(System.in);
            int movieID = scanner.nextInt();
            for (OnlineScreening movie: Main.onlineMovies) {
                if (movie.getMovieID() == movieID) {
                    String url = "https://www.georgebrownfilmfestival.com/movies/" +
                            movie.getTitle().replaceAll("\\s","");
                    System.out.println("Click on the link to watch movie: " + url);
                }
            }
            System.out.println("Select a different movie");
        }else{
            System.out.println("You haven't purchased any online movie");
        }
    }
}
