package pindorama.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(RedirectRequest.class);
    @GetMapping("redirect/adm")
    public ModelAndView redirectToAdm(HttpServletRequest request) {

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

    @GetMapping(path = "/")
    public String welcomePindoramaApi() {
        return "Pindorama API: 1.0v";
    }
}
