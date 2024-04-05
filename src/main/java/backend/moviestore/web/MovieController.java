package backend.moviestore.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
