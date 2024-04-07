package backend.moviestore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.moviestore.domain.Genre;
import backend.moviestore.domain.GenreRepository;
import backend.moviestore.domain.Movie;
import backend.moviestore.domain.MovieRepository;

@SpringBootApplication
public class MoviestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviestoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MovieRepository mRepository, GenreRepository gRepository) {
		return (args) -> {
			

			Genre genre1 = new Genre("Action");
			gRepository.save(genre1);
			Genre genre2 = new Genre("Thriller");
			gRepository.save(genre2);
			Genre genre3 = new Genre("Horror");
			gRepository.save(genre3);
			Genre genre4 = new Genre("Comedy");
			gRepository.save(genre4);
			Genre genre5 = new Genre("Romance");
			gRepository.save(genre5);
			Genre genre6 = new Genre("Drama");
			gRepository.save(genre6);
			Genre genre7 = new Genre("Science fiction");
			gRepository.save(genre7);
			
			mRepository.save(new Movie("Titanic", 1997, 4.99, genre5));
			mRepository.save(new Movie("Endgame", 2019, 9.99, genre1));
			mRepository.save(new Movie("Guardians of the Galaxy Vol.3", 2023, 11.99, genre7));
			mRepository.save(new Movie("Spider-Man: No Way Home", 2021, 9.99, genre1));

		};
	}

}
