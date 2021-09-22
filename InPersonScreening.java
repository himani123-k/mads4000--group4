
import java.time.LocalTime;
import java.util.ArrayList;

public class InPersonScreening extends Movie {
    private String address;
    private String audi;
    private int capacity;
    private String timeslot;
    private String entryPolicy;

    public InPersonScreening() {
        this.entryPolicy = "Vaccinated";
    }

    public InPersonScreening(String address, String audi, int capacity, String timeslot, int movieID, String title,
                             String director, String description, String genre, LocalTime time, boolean isOnline) {

        super(movieID, title, director, description, genre, time, isOnline);
        this.address = address;
        this.capacity = capacity;
        this.timeslot = timeslot;
        this.entryPolicy = "Vaccinated";
        this.audi = audi;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTimeslot() {
        return this.timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getEntryPolicy() {
        return entryPolicy;
    }

    public void setEntryPolicy(String entryPolicy) {
        this.entryPolicy = entryPolicy;
    }

    public String getAudi() {
        return audi;
    }

    public void setAudi(String audi) {
        this.audi = audi;
    }

    public ArrayList<InPersonScreening> createMovies(){

        ArrayList<InPersonScreening> movies = new ArrayList<>();

        movies.add(new InPersonScreening("259 Richmond Street West, Toronto, ON, M5V 3M6", "AUDI 3",3,
                "Morning", Main.onlineMovies.size() + movies.size(), "Avengers: Endgame",
                "Anthony Russo", "After Thanos, an intergalactic warlord, disintegrates half " +
                "of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced " +
                "allies and restore balance.", "Action/Sci-fi", LocalTime.of(3, 2), false));

        movies.add(new InPersonScreening("12 Marie Labatte Road, Toronto, ON", "AUDI 2", 3, "Afternoon",
                Main.onlineMovies.size() + movies.size(), "Dilwale Dulhania Le Jayenge",
                "Aditya Chopra", "Raj and Simran meet during a trip across Europe and the two fall " +
                "in love. However, when Raj learns that Simran is already promised to another, he follows her to " +
                "India to win her and her father over.", "Romance/Musical", LocalTime.of(3, 9), false));

        movies.add(new InPersonScreening("12 Marie Labatte Road, Toronto, ON", "AUDI 1", 3, "Evening",
                Main.onlineMovies.size() + movies.size(), "Inception",
                "Christopher Nolan", "Cobb steals information from his targets by entering their " +
                "dreams. Saito offers to wipe clean Cobb's criminal history as payment for performing an inception " +
                "on his sick competitor's son.", "Romance/Musical", LocalTime.of(2, 28), false));

        return movies;
    }

    public void displayMovies(ArrayList<InPersonScreening> movies){

        System.out.println("\nIn person Movies: ");
        System.out.printf("%-5s %-30s %-15s %s\n", "ID", "Title", "Timeslot", "Runtime");
        for (InPersonScreening movie: movies) {
            System.out.printf("%-5s %-30s %-15s %s\n", movie.getMovieID(),
                    movie.getTitle(), movie.getTimeslot(), movie.getRunTime());
        }
    }
}
