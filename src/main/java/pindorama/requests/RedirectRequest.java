package pindorama.requests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pindorama.database.User;
import pindorama.utils.enums.UserType;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class RedirectRequest {

    @GetMapping("redirect/adm")
    public ModelAndView redirectToAdm(HttpServletRequest request) {

        var session = request.getSession(false);

        if(session == null){
            return new ModelAndView("redirect:/index");
        }

        var user = (User) session.getAttribute("user");

        if (user.getUserType() == UserType.ADM) {
            return new ModelAndView("redirect:/controller/panel");
        }

        return new ModelAndView("redirect:/index");
    }

    @GetMapping(path = "/")
    public String welcomePindoramaApi() {
        return "Pindorama API: 1.0v";
    }
}
