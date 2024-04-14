package backend.moviestore.web;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.moviestore.domain.GenreRepository;
import backend.moviestore.domain.Movie;
import backend.moviestore.domain.MovieRepository;



@Controller
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository gRepository;

    @RequestMapping (value = "/movielist", method = RequestMethod.GET)
    public String movieList(Model model) {
        model.addAttribute("movies", repository.findAll());

        // http://localhost:8080/movielist
        return "movielist"; // movielist.html
    }

    // handle deleting movie
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMovie(@PathVariable("id") Long movieId, Model model){
        repository.deleteById(movieId);
        return "redirect:../movielist";
    }

    // handle Adding new movie action
    @GetMapping("/addmovie")
    public String addmovie (Model model){

        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", gRepository.findAll());

        return "addmovie"; // addmovie.html
    }

    // handle Saving new movie action
    @PostMapping("/save")
    public String save (Movie movie){
        repository.save(movie);
        return "redirect:movielist";
    }

    // Add movie to cart
    private List<Movie> cart = new ArrayList<>(); // New cart list
    @GetMapping("/addtocart/{id}") 
    public String addToCart(@PathVariable("id") Long movieId) {
         Movie movie = repository.findById(movieId).orElse(null);
          if (movie != null) { 
            cart.add(movie);
         } 
         return "redirect:/movielist";
         } // Redirect back to the movies list }
    
    
    
@GetMapping("/addtocart")
public String showCart(Model model){
    model.addAttribute("cart", cart);

    // Calculate the total price
    double totalPrice = cart.stream()
                            .mapToDouble(Movie::getPrice) // Extract prices
                            .sum(); // Sum prices

    model.addAttribute("totalPrice", totalPrice);
    return "addtocart";
}
    
@GetMapping("/removefromcart/{id}")
public String removeFromCart(@PathVariable("id") Long movieId) {
    // Find the movie in the cart by id
    Movie movieToRemove = cart.stream()
                              .filter(movie -> movieId.equals(movieId))
                              .findFirst()
                              .orElse(null);
    
    // If the movie is found, remove it from the cart
    if (movieToRemove != null) {
        cart.remove(movieToRemove);
    }
    
    return "redirect:/addtocart";
}


}
