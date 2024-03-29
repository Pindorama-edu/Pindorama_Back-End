package pindorama.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;
import pindorama.utils.enums.UserType;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class RedirectRequest {

    private final static Logger logger = LoggerFactory.getLogger(RedirectRequest.class);
    @GetMapping("redirect/adm/{id}")
    public ModelAndView redirectToAdm(@PathVariable int id,
            HttpServletRequest request) {

        var session = request.getSession(false);

        if(session == null){
            return new ModelAndView("redirect:/");
        }

        var user = (User) session.getAttribute("user");

        if (user.getUserType() == UserType.ADM) {
            logger.info("O Adminstrador {} logou no Painel.", user.getUsername());

            return new ModelAndView("redirect:/controller/panel");
        }

        return new ModelAndView("redirect:/");
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("redirect/user")
    public ModelAndView reloadUserInSession(
                                      HttpServletRequest request) {

        var session = request.getSession(false);

        if(session != null && session.getAttribute("user") != null){

            var user = (User) session.getAttribute("user");

            session.removeAttribute("user");

            session.setAttribute("user", userRepository.findByEmail(user.getEmail()));

            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping(path = "/")
    public String welcomePindoramaApi() {
        return "Pindorama API: 1.0v";
    }
}
