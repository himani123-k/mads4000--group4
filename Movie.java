

import java.time.LocalTime;

public class Movie {
    private int movieID;
    private String title;
    private String director;
    private String description;
    private String genre;
    private LocalTime runTime;
    private boolean isOnline;

    public Movie() {
    }

    public Movie(int movieID, String title, String director, String description, String genre, LocalTime runTime, boolean isOnline) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.description = description;
        this.genre = genre;
        this.runTime = runTime;
        this.isOnline = isOnline;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalTime getRunTime() {
        return this.runTime;
    }

    public void setRunTime(LocalTime time) {
        this.runTime = time;
    }

    public int getMovieID() {
        return this.movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
               ", director='" + director + '\'' +
               ", description='" + description + '\'' +
               ", genre='" + genre + '\'' +
               ", time=" + runTime;
    }

    public void displayMovies(){
        new OnlineScreening().displayMovies(Main.onlineMovies);
        new InPersonScreening().displayMovies(Main.inPersonMovies);
    }
}
