package backend.moviestore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genreId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private List<Movie> movies;
    // getter and setter movies
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
     

    public Genre(){}

        // getters and setters
    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //constructor
    public Genre(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", name=" + name + "]";
    }

    


    


}
