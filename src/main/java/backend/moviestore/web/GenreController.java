package backend.moviestore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
