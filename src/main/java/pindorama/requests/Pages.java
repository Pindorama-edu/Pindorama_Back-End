package pindorama.requests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class Pages {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("redirect:/logue.html");
    }
}
