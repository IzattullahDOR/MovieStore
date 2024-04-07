package backend.moviestore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import backend.moviestore.domain.Genre;
import backend.moviestore.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository gRepository;

    @GetMapping("/genrelist")
    private String genreList(Model model){

        model.addAttribute("genres", gRepository.findAll());
        return "genrelist";
    }

    // handle add genre
    @GetMapping("/addgenre")
    public String addgenre(Model model) {

        model.addAttribute("genre",new Genre());
        return "/addgenre"; //addcategory.html
    }

    // handle Save new genre
    @PostMapping("/savegenre")
    public String save(Genre genre){
        gRepository.save(genre);
        return "redirect:genrelist";
    }


}
