package backend.moviestore.web;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MovieController {

    

    @RequestMapping (value = "/movielist", method = RequestMethod.GET)
    public String hello(Model model) {

        // http://localhost:8080/movielist
        return "movielist"; // movielist.html
    }

}
