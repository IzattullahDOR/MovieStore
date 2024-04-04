package backend.moviestore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.moviestore.domain.Movie;
import backend.moviestore.domain.MovieRepository;

@SpringBootApplication
public class MoviestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviestoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {
			Movie movie1 = new Movie("Titanic", 1997, 4.99);
			repository.save(movie1);
			Movie movie2 = new Movie("Endgame", 2019, 9.99);
			repository.save(movie2);
			Movie movie3 = new Movie("Guardians of the Galaxy Vol.3", 2023, 11.99);
			repository.save(movie3);
			Movie movie4 = new Movie("Spider-Man: No Way Home", 2021, 9.99);
			repository.save(movie4);

			


		};
	}

}
