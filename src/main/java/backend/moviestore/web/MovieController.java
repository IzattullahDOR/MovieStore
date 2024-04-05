package backend.moviestore.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.moviestore.domain.Movie;
import backend.moviestore.domain.MovieRepository;



@Controller
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @RequestMapping (value = "/movielist", method = RequestMethod.GET)
    public String movieList(Model model) {
        model.addAttribute("movies", repository.findAll());

        // http://localhost:8080/movielist
        return "movielist"; // movielist.html
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long MovieId, Model model){
        repository.deleteById(MovieId);
        return "redirect:../movielist";
    }

    // Adding new movie
    @GetMapping("/addmovie")
    public String addmovie (Model model){

        model.addAttribute("movie", new Movie());

        return "addmovie"; // addmovie.html
    }

    // Saving new movie
    @PostMapping("/save")
    public String save (Movie movie){
        repository.save(movie);
        return "redirect:movielist";
    }
    

    

}
